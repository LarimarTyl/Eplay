package bean;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 15:53
 */
public class RelationshipBean {
    private int id;//关系表id
    private int userID;
    private String staffName;//用户名
    private String playerName;//玩家名
    private int playerID;//玩家id
    private String photoPath;//根据玩家id拿到的玩家头像路径
    private String gameName;//玩家游戏
    private String picPath;//根据玩家id拿到的玩家图片
    private String introduce;//根据玩家id拿到的玩家介绍
    private int status;//关系状态 0关注（默认）  1（拉黑）

    public RelationshipBean() {
    }

    public RelationshipBean(int userID,int playerID,int status){
        this.userID=userID;
        this.playerID=playerID;
        this.status=status;
    }
    public RelationshipBean(int id, String staffName, String playerName, String photoPath, String gameName, String picPath, String introduce) {
        this.id = id;
        this.staffName = staffName;
        this.playerName = playerName;
        this.photoPath = photoPath;
        this.gameName = gameName;
        this.picPath = picPath;
        this.introduce = introduce;
    }

    public RelationshipBean(int id, int userID, String staffName, String playerName, int playerID, String photoPath, String gameName, String picPath, String introduce, int status) {
        this.id = id;
        this.userID = userID;
        this.staffName = staffName;
        this.playerName = playerName;
        this.playerID = playerID;
        this.photoPath = photoPath;
        this.gameName = gameName;
        this.picPath = picPath;
        this.introduce = introduce;
        this.status = status;
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RelationshipBean{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", playerName='" + playerName + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", gameName='" + gameName + '\'' +
                ", picPath='" + picPath + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
