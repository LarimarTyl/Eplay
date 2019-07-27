package dao;

import bean.UserBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:19
 */
public interface UserDao {
    public boolean saveUser(UserBean user);//保存用户信息1
    public boolean delUser(UserBean user);//删除用户信息1
    public boolean updateUser(UserBean user);//更新用户信息1
    public UserBean loginCheck(String loginName,String loginPwd); //登录验证
    public UserBean selectUserByCode(UserBean user);//根据注册码查找用户1
    public UserBean selectUserByName(String name);//根据用户名查找用户信息1
    public UserBean selectUserByUserID(int userId);//根据用户id查找用户信息1
    public UserBean selectUserByLoginName(String loginName);//通过登录名查找用户信息
    public int selectRegisterStatusByLoginName(String loginName);//通过登录名查询注册状态
    public int selectStatusByStaffNumber(String staffNumber);//通过用户编号查询用户状态（1用户，2待审核用户，3玩家，0管理员）
    public List<UserBean> selectAllUser();//查找所有用户信息
    public List<UserBean> pageAllUser(int currentPage,int pageSize);//分页查找所有用户信息
    public List<UserBean> selectUsersByRegisterStatus(int registerStatus);//根据用户注册状态查找用户（是否激活）
    public List<UserBean> pageUsersByRegisterStatus(int registerStatus,int currentPage,int pageSize);//根据用户注册状态分页查找用户（是否激活）
    public List<UserBean> selectUsersBySpend();//查找高消费用户
    public List<UserBean> selectUsersByStatus(int status);//根据用户状态查找用户（玩家、用户、管理员）
    public List<UserBean> pageUsersByStatus(int status,int currentPage,int pageSize);//根据用户状态查找用户（玩家、用户、管理员）
    public List<UserBean> selectUsersByender(String gender);//根据性别查找用户
    public double selectMoneyById(int id);//根据用户名查余额
    public boolean updateMoneyById(UserBean user);//修改余额通过Id
}
