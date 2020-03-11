package cn.cmcc.diseasemonitor.ws;

import cn.cmcc.diseasemonitor.controller.ControllerUtil;
import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.entity.Order;
import cn.cmcc.diseasemonitor.entity.User;
import cn.cmcc.diseasemonitor.service.LaboratoryService;
import cn.cmcc.diseasemonitor.service.OrderService;
import cn.cmcc.diseasemonitor.service.UserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
@ServerEndpoint("/websocket/{token}")
@Component
public class WebSocketServer {

    private static UserService userService;

    private static LaboratoryService laboratoryService;

    private static OrderService orderService;

    private static Integer milions = 5000;

    // 存放客户端 websocket 连接信息
    private static CopyOnWriteArraySet<WebSocketServer> webSocketServers = new CopyOnWriteArraySet<>();
    // 和客户端的状态情况
    private Session session;

    // 只有使用token才能确认客户端是哪位身份
    private String token;

    @OnOpen
    public void onOpen(Session session, @PathParam("token")String token){
        this.session = session;
        webSocketServers.add(this);
        this.token = token;
        log.info("websocket:新的连接加入! ID:{}", session.getId());
        sendMessage(ControllerUtil.getSuccessResultBySelf(new ArrayList()));
    }

    @OnClose
    public void onClose(){
        log.info("websocket:用户退出会话,ID:{}", session.getId());
        webSocketServers.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session){
        User user = userService.findUserByToken(token).orElse(null);
        if (user == null){
            sendMessage(ControllerUtil.getFalseResultMsgBySelf("身份信息错误,查询失败"));
            return;
        }
        Laboratory laboratory = laboratoryService.findByUserId(user.getId()).orElse(null);
        if (null == laboratory){
            sendMessage(ControllerUtil.getFalseResultMsgBySelf("无法找到实验室信息,查询失败"));
            return;
        }
        List<Order> orders = orderService.findByLaboratoryAndNotified(laboratory.getId(), false);
        List<String> orderSns = new ArrayList<>();
        orders.forEach(order -> {
            orderSns.add(order.getOrderSn());
        });
        sendMessage(ControllerUtil.customResult(100,"查询成功", orderSns));
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        log.error("websocket发生错误");
        throwable.printStackTrace();

    }

    /**
     * 发送可以序列化的消息
     * @param message
     */
    public void sendMessage(Serializable message){
        try {
            this.session.getBasicRemote().
                    sendText((message instanceof String)?(String) message:JSON.toJSONString(message));
        } catch (IOException e) {
            log.error(e.getMessage());
            log.error("错误! 发送消息失败,ID:{}", this.session.getId());
        }
    }

    // 解决在websocket中无法注入的问题
    // https://blog.csdn.net/m0_37202351/article/details/86255132
    @Autowired
    public void setUserService(UserService userService) {
        WebSocketServer.userService = userService;
    }
    @Autowired
    public void setLaboratoryService(LaboratoryService laboratoryService) {
        WebSocketServer.laboratoryService = laboratoryService;
    }
    @Autowired
    public void setOrderService(OrderService orderService) {
        WebSocketServer.orderService = orderService;
    }
}

