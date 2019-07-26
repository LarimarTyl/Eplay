package bean;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 15:48
 */
public class LoveGameBean {
    private int id ; //游戏爱好id
    private int userID;//用户id
    private String staffName;//用户名
    private int gameID;//游戏id
    private String gameName;//游戏名
    /*空参构造*/
    public LoveGameBean() {
    }
    /*获取关注游戏列表的构造*/
    public LoveGameBean(String gameName) {
        this.gameName = gameName;
    }

    public LoveGameBean(int userID, int gameID) {
        this.userID = userID;
        this.gameID = gameID;
    }

    /*全参构造*/
    public LoveGameBean(int id, String staffName, String gameName) {
        this.id = id;
        this.staffName = staffName;
        this.gameName = gameName;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    @Override
    public String toString() {
        return "LoveGameBean{" +
                "id=" + id +
                ", userID=" + userID +
                ", staffName='" + staffName + '\'' +
                ", gameID='" + gameID + '\'' +
                ", gameName='" + gameName + '\'' +
                '}';
    }
}
