package bean;

import java.util.Random;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 15:19
 */
public class PlayerBean {
    private int id;//玩家表id
    private int playerID;//玩家用户id
    private String  staffName;//根据用户id拿到的用户名
    private int gameID;//游戏id
    private String level;//游戏等级
    private String gameName;//根据游戏id拿到的游戏名
    private String photoPath;//根据玩家id拿到的头像路径
    private String gender;//根据用户id拿到的性别
    private String picPath;//用户游戏图片路径
    private  String gameLeve;//根据游戏等级id拿到的游戏段位
    private  int orderNum;//订单数
    private  double money;//单价
    private  String introduce;//介绍
    private int status;//玩家状态 0未接单 1待接单 2已接单

    public PlayerBean() {
    }

    public PlayerBean(int playerID, int gameID, double money) {
        this.playerID = playerID;
        this.gameID = gameID;
        this.money = money;
    }

    public PlayerBean(String picPath, int orderNum, double money, String introduce, int status, int id) {
        this.id = id;
        this.picPath = picPath;
        this.orderNum = orderNum;
        this.money = money;
        this.introduce = introduce;
        this.status = status;
    }



    public PlayerBean(int id, String staffName, String gameName, String photoPath, String gender, String picPath, String gameLeve, int orderNum, double money, String introduce, int status) {
        this.id = id;
        this.staffName = staffName;
        this.gameName = gameName;
        this.photoPath = photoPath;
        this.gender = gender;
        this.picPath = picPath;
        this.gameLeve = gameLeve;
        this.orderNum = orderNum;
        this.money = money;
        this.introduce = introduce;
        this.status = status;
    }

    public PlayerBean(int id, int playerID, String staffName, int gameID, String gameName, String photoPath, String gender, String picPath, String gameLeve, int orderNum, double money, String introduce, int status) {
        this.id = id;
        this.playerID = playerID;
        this.staffName = staffName;
        this.gameID = gameID;
        this.gameName = gameName;
        this.photoPath = photoPath;
        this.gender = gender;
        this.picPath = picPath;
        this.gameLeve = gameLeve;
        this.orderNum = orderNum;
        this.money = money;
        this.introduce = introduce;
        this.status = status;
    }

    public PlayerBean(int id) {
        this.id=id;
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

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGameLeve() {
        return gameLeve;
    }

    public void setGameLeve(String gameLeve) {
        this.gameLeve = gameLeve;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    @Override
    public String toString() {
        return "PlayerBean{" +
                "staffName='" + staffName + '\'' +
                ", gameName='" + gameName + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", gender='" + gender + '\'' +
                ", picPath='" + picPath + '\'' +
                ", gameLeve='" + gameLeve + '\'' +
                ", orderNum=" + orderNum +
                ", money=" + money +
                ", introduce='" + introduce + '\'' +
                ", status=" + status +
                '}';
    }
}
