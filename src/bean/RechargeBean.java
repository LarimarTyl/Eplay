package bean;

import java.util.Date;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 15:42
 */
public class RechargeBean {
    private int id;//充值订单编号
    private int userID ;//用户id
    private String staffName;//用户名
    private double money;//充值金额
    private int type;//充值方式 1：支付宝 2：微信 默认支付宝
    private String time;//充值时间

    public RechargeBean() {
    }

    public RechargeBean(int id, int userID, String staffName, double money, int type, String time) {
        this.id = id;
        this.userID = userID;
        this.staffName = staffName;
        this.money = money;
        this.type = type;
        this.time = time;
    }

    public RechargeBean(int userID, String staffName, double money, int type, String time) {
        this.userID = userID;
        this.staffName = staffName;
        this.money = money;
        this.type = type;
        this.time = time;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RechargeBean{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", money=" + money +
                ", time=" + time +
                '}';
    }
}
