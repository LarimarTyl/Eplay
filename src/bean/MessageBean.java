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
    private Date time;//消息时间

    /*空参构造*/
    public MessageBean() {
    }

    /*全参构造*/
    public MessageBean(int id, String message, int status, int type, Date time) {
        this.id = id;
        this.message = message;
        this.status = status;
        this.type = type;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", time=" + time +
                '}';
    }
}
