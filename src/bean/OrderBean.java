package bean;

import java.util.Date;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 15:28
 */
public class OrderBean {

    private int id; //订单编号
    private int gameID;//游戏id
    private String gameName; //根据游戏id拿到的游戏名
    private int userID;//用户id
    private String staffName;//根据用户id拿到的用户名
    private int playerID;//玩家id
    private String playerName;//根据玩家id拿到的玩家名

    private String contact;//联系方式
    private int payWay;//付款方式（1直接付款 2余额支付）
    private String starttime;//开始时间
    private String endtime;//结束时间
    private double price;//总价格
    private int poitns;//评分
    private String appraise;//客户评论
    private String remark;//备注
    private int status;//订单状态

    public OrderBean() {
    }
    public OrderBean(int id, int gameID, String gameName, int userID, String staffName, int playerID, String playerName, String contact, String starttime, String endtime, double price, int poitns, String appraise, String remark) {
        this.id = id;
        this.gameID = gameID;
        this.gameName = gameName;
        this.userID = userID;
        this.staffName = staffName;
        this.playerID = playerID;
        this.playerName = playerName;
        this.contact = contact;
        this.starttime = starttime;
        this.endtime = endtime;
        this.price = price;
        this.poitns = poitns;
        this.appraise = appraise;
        this.remark = remark;
    }

    public OrderBean(int gameID, int userID, int playerID, String contact, int payWay, String starttime, String endtime, double price, String appraise, String remark) {
        this.gameID = gameID;
        this.userID = userID;
        this.playerID = playerID;
        this.contact = contact;
        this.payWay = payWay;
        this.starttime = starttime;
        this.endtime = endtime;
        this.price = price;
        this.appraise = appraise;
        this.remark = remark;
    }

    public OrderBean(int id, int gameID, String gameName, int userID, String staffName, int playerID, String playerName, String contact, int payWay, String starttime, String endtime, double price, int poitns, String appraise, String remark) {
        this.id = id;
        this.gameID = gameID;
        this.gameName = gameName;
        this.userID = userID;
        this.staffName = staffName;
        this.playerID = playerID;
        this.playerName = playerName;
        this.contact = contact;
        this.payWay = payWay;
        this.starttime = starttime;
        this.endtime = endtime;
        this.price = price;
        this.poitns = poitns;
        this.appraise = appraise;
        this.remark = remark;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPoitns() {
        return poitns;
    }

    public void setPoitns(int poitns) {
        this.poitns = poitns;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPayWay() {
        return payWay;
    }

    public void setPayWay(int payway) {
        this.payWay = payway;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", gameID=" + gameID +
                ", gameName='" + gameName + '\'' +
                ", userID=" + userID +
                ", staffName='" + staffName + '\'' +
                ", playerID=" + playerID +
                ", playerName='" + playerName + '\'' +
                ", contact='" + contact + '\'' +
                ", payWay=" + payWay +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", price=" + price +
                ", poitns=" + poitns +
                ", appraise='" + appraise + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                '}';
    }
}
