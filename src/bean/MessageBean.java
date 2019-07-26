package bean;

import java.util.Date;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 15:45
 */
public class MessageBean {
    private int id; //消息id
    private int userID;//用户id
    private String staffName;//用户名
    private String message; //消息内容
    private int status;//消息状态 0未读  1已读
    private int type;//消息类型 0系统消息 1用户消息
    private String time;//消息时间

    /*空参构造*/
    public MessageBean() {
    }

    public MessageBean(int id, int userID, String staffName, String message, int status, int type, String time) {
        this.id = id;
        this.userID = userID;
        this.staffName = staffName;
        this.message = message;
        this.status = status;
        this.type = type;
        this.time = time;
    }

    /*全参构造*/
    public MessageBean(int id, String message, int status, int type, String time) {
        this.id = id;
        this.message = message;
        this.status = status;
        this.type = type;
    }

    public MessageBean(int userID, String staffName, String message, int status, int type) {
        this.userID = userID;
        this.staffName = staffName;
        this.message = message;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "id=" + id +
                ", userID=" + userID +
                ", staffName='" + staffName + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", time='" + time + '\'' +
                '}';
    }
}
