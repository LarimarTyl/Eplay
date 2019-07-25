package dao;

import bean.UserBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:19
 */
public interface UserDao {
    public boolean saveUser(UserBean user);//保存用户信息
    public boolean delUser(UserBean user);//删除用户信息
    public boolean updateUser(UserBean user);//更新用户信息
    public UserBean selectUserByCode(UserBean user);//根据注册码查找用户
    public UserBean selectUserByName(String name);//根据用户名查找用户信息
    public UserBean selectUserByUserID(String userId);//根据用户id查找用户信息
    public List<UserBean> selectAllUser();//查找所有用户信息
    public List<UserBean> pageAllUser(int currentPage,int pageSize);//分页查找所有用户信息
    public List<UserBean> selectUsersByRegisterStatus(int registerStatus);//根据用户注册状态查找用户（是否激活）
    public List<UserBean> pageUsersByRegisterStatus(int registerStatus,int currentPage,int pageSize);//根据用户注册状态分页查找用户（是否激活）
    public List<UserBean> selectUsersBySpend();//查找高消费用户
    public List<UserBean> selectUsersByStatus(int status);//根据用户状态查找用户（玩家、用户、管理员）
    public List<UserBean> pageUsersByStatus(int status,int currentPage,int pageSize);//根据用户状态查找用户（玩家、用户、管理员）
    public List<UserBean> selectUsersByender(String gender);//根据性别查找用户

}
