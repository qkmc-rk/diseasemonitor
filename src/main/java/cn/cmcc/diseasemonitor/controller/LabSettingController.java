package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.entity.Repertory;
import cn.cmcc.diseasemonitor.service.LaboratoryService;
import cn.cmcc.diseasemonitor.service.PicService;
import cn.cmcc.diseasemonitor.service.RepertoryService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import cn.cmcc.diseasemonitor.vo.TestItem;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 * coding by mrruan
 * 功能: 基础信息:(实验室信息/样品邮寄地址)
 * 检测项目配置:查询检测项目列表(已上架(查详情/编辑/下架)/已下架(查详情/编辑/下架))
 *
 */
@RestController
@RequestMapping("/laboratory")
public class LabSettingController {

    @Autowired
    LaboratoryService laboratoryService;
    @Autowired
    PicService picService;
    @Autowired
    RepertoryService repertoryService;

    @GetMapping("")
    @ApiOperation(value="获取实验室信息")
    public ResponseEntity getLabInfo(@RequestHeader("token") String token){
        return ControllerUtil.getDataResult(laboratoryService.findLaboratory(token));
    }

    @GetMapping("/logo")
    @ApiOperation(value = "获取用户的logo")
    public ResponseEntity getLabLogo(@RequestHeader("token") String token){
        return ControllerUtil.getDataResult(laboratoryService.getLogo(token));
    }

    @PostMapping("")
    @ApiOperation(value = "更新lab信息", notes = "lab的Id必须传，如果id有问题，就会返回空数据")
    public ResponseEntity saveLab(@RequestBody Laboratory laboratory){
        return ControllerUtil.getDataResult(laboratoryService.save(laboratory));
    }

    /**
     *  获取上架了的实验室 检测项目
     * @param token
     * @return
     */
    @GetMapping("/item/onsale")
    @ApiOperation(value="获取上架的库存信息")
    public ResponseEntity getOnSaleServe(@RequestHeader("token") String token){
        return ControllerUtil.getDataResult(repertoryService.findAllOnSaleServe(token));
    }

    /**
     *  获取下架了的实验室 检测项目
     * @param token
     * @return
     */
    @GetMapping("/item/offsale")
    @ApiOperation(value="获取下架的库存信息")
    public ResponseEntity getOffSaleServe(@RequestHeader("token") String token){
        return ControllerUtil.getDataResult(repertoryService.findAllOffSaleServe(token));
    }

    @GetMapping("/item/{repertoryId}")
    @ApiOperation(value = "根据传入id获取repetory记录的详细信息")
    public ResponseEntity getOneServe(@RequestHeader("token") String token
            ,Integer repertoryId){
            return ControllerUtil.getDataResult(repertoryService.findOneByRepertoryId(token, repertoryId));
    }

    @PostMapping("/item/{repertoryId}")
    @ApiOperation(value="修改价格和库存")
    public ResponseEntity modifyPriceAndInventory(@PathVariable Integer repertoryId
            , @RequestParam Double price, @RequestParam Integer inventory){
        Repertory repertory = repertoryService.modifyPriceAndInventory(repertoryId, price, inventory);
        return ControllerUtil.getDataResult(repertory);
    }

    @PostMapping("/item/{repertoryId}/on")
    @ApiOperation(value="上架商品")
    public ResponseEntity offSaleToOnSale(@PathVariable Integer repertoryId){
        return ControllerUtil.getDataResult(repertoryService.changeRepertoryStatus(repertoryId, "1"));
    }

    @PostMapping("/item/{repertoryId}/off")
    @ApiOperation(value="下架商品")
    public ResponseEntity OnSaleToOffSale(@PathVariable Integer repertoryId){
        return ControllerUtil.getDataResult(repertoryService.changeRepertoryStatus(repertoryId, "0"));
    }

}
