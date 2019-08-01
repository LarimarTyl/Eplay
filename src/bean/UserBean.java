package bean;

import java.util.Date;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 15:06
 */
public class UserBean {
    private int id ;//用户id
    private String loginName;//登录账号
    private String loginPwd;//登录密码
    private String staffNumber;//用户编号
    private String staffName;//用户名
    private String birthday;//生日
    private String gender;//性别
    private String email;//邮箱
    private String telephone;//电话
    private String photoPath;//头像路径
    private double price;//总花费
    private double money;//余额
    private String QQ;//QQ号码
    private String  registerTime;//注册时间
    private  int registerStatus;//注册状态 0未激活 1已激活
    private  String code;//注册码
    private int status;//账号状态 0管理员 1普通用户 2待审核玩家 3审核通过玩家

    public UserBean() {
    }

    public UserBean(String loginName, String loginPwd, String gender, String email, String telephone, String QQ) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.gender = gender;
        this.email = email;
        this.telephone = telephone;
        this.QQ = QQ;
    }

    public UserBean(int id, String telephone, double price, double money) {
        this.id = id;
        this.telephone = telephone;
        this.price = price;
        this.money = money;
    }

        public UserBean(int id, String loginName, String loginPwd, String staffNumber, String staffName, String birthday, String gender, String email, String telephone, String photoPath, double price, double money, String QQ, String registerTime) {
        this.id = id;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffNumber = staffNumber;
        this.staffName = staffName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.telephone = telephone;
        this.photoPath = photoPath;
        this.price = price;
        this.money = money;
        this.QQ = QQ;
        this.registerTime = registerTime;
    }

    public UserBean(int id, String loginName, String loginPwd, String staffNumber, String staffName, String birthday, String gender, String email, String telephone, String photoPath, double price, double money, String QQ, String registerTime, int registerStatus, String code, int status) {
        this.id = id;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffNumber = staffNumber;
        this.staffName = staffName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.telephone = telephone;
        this.photoPath = photoPath;
        this.price = price;
        this.money = money;
        this.QQ = QQ;
        this.registerTime = registerTime;
        this.registerStatus = registerStatus;
        this.code = code;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public int getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(int registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffNumber='" + staffNumber + '\'' +
                ", staffName='" + staffName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", price=" + price +
                ", money=" + money +
                ", QQ='" + QQ + '\'' +
                ", registerTime=" + registerTime +
                ", registerStatus=" + registerStatus +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
