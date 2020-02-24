package cn.cmcc.diseasemonitor.util.constant;

public enum LogisticsStatusType {
    CANCEL("已取消", "0"), UNPAID("待付款", "1"),
    UNSENT("待寄样", "2"), INTRANSIT("运输中", "3"),
    CHECKING("检测中", "4"), COMPLETED("已完成", "5"),
    REFUNDING("退款中", "6");

    private String name;
    private String index;

    LogisticsStatusType(String name, String index) {
        this.name = name;
        this.index = index;
    }
}
