package dao;

import bean.UserBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:19
 */
public interface UserDao {
    /**
     * 根据UserBean添加用户信息
     * @param user 用户对象
     * @return 返回插入的结果
     */
    public boolean saveUser(UserBean user);

    /**
     * 根据UserBean删除用户信息（实质是通过UserBean的id属性删除）
     * @param user 用户对象
     * @return 返回删除的结果
     */
    public boolean delUser(UserBean user);

    /**
     * 根据UserBean更新用户信息
     * @param user 用户的对象
     * @return 返回更新的结果
     */
    public boolean updateUser(UserBean user);

    /**
     * 登录验证 通过登录账号和登录密码
     * @param loginName 登录名（用户名或登录名都可）
     * @param loginPwd 登录密码
     * @return 返回检索到匹配的用户
     */
    public UserBean loginCheck(String loginName,String loginPwd);

    /**
     * 根据注册码 查询用户
     * @param code 注册码
     * @return 返回注册码对应的用户
     */
    public UserBean selectUserByCode(String code);

    /**
     * 根据用户名查找用户信息
     * @param name 用户名
     * @return 返回用户名对应的用户
     */
    public UserBean selectUserByName(String name);

    /**
     * 根据用户id查找用户信息
     * @param userId 用户id
     * @return 返回该id对应的用户
     */
    public UserBean selectUserByUserID(int userId);

    /**
     * 通过登录名查找用户信息
     * @param loginName 登录名
     * @return 登录名对应的用户信息
     */
    public UserBean selectUserByLoginName(String loginName);

    /**
     * 通过登录名查找用户注册状态
     * @param loginName 登录名
     * @return 登录名对应的用户注册状态
     */
    public int selectRegisterStatusByLoginName(String loginName);

    /**
     * 通过用户标号查询用户状态
     * @param staffNumber 用户编号
     * @return 返回用户状态（1用户，2待审核用户，3玩家，0管理员）
     */
    public int selectStatusByStaffNumber(String staffNumber);

    /**
     * 查找所有用户信息
     * @return 所有用户集合
     */
    public List<UserBean> selectAllUser();

    /**
     * //分页查找所有用户信息  起始位置 页面大小
     * @param currentPage 当前页面
     * @param pageSize 页面大小
     * @return 返回分页所有用户对象
     */
    public List<UserBean> pageAllUser(int currentPage,int pageSize);

    /**
     * 根据用户注册状态查找用户（是否激活）
     * @param registerStatus 注册状态
     * @return 返回对应状态的用户集合
     */
    public List<UserBean> selectUsersByRegisterStatus(int registerStatus);

    /**
     * 根据用户注册状态分页查找用户（是否激活）
     * @param registerStatus 注册状态
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 返回分页当前状态的用户集合
     */
    public List<UserBean> pageUsersByRegisterStatus(int registerStatus,int currentPage,int pageSize);

    /**
     * 查找高消费用户（消费榜前10）
     * @return 返回高消费用户集合
     */
    public List<UserBean> selectUsersBySpend();

    /**
     * 根据用户状态查找用户（玩家、用户、管理员）
     * @param status 用户状态 （1用户，2待审核用户，3玩家，0管理员）
     * @return 返回该状态对应的用户集合
     */
    public List<UserBean> selectUsersByStatus(int status);

    /**
     * 分页根据用户状态查找用户（玩家、用户、管理员）
     * @param status  用户状态 （1用户，2待审核用户，3玩家，0管理员）
     * @param currentPage 当前页面
     * @param pageSize 页面大小
     * @return
     */
    public List<UserBean> pageUsersByStatus(int status,int currentPage,int pageSize);

    /**
     * 根据性别查找用户
     * @param gender 性别
     * @return 返回对应性别的用户集合
     */
    public List<UserBean> selectUsersByender(String gender);

    /**
     * 根据用户id查余额
     * @param id 用户id
     * @return 返回当前id对应用户的余额
     */
    public double selectMoneyById(int id);

    /**
     * 修改余额通过Id（从用户对象中拿到id）
     * @param user 用户对象
     * @return 返回用户对象更新的状态
     */
    public boolean updateMoneyById(UserBean user);
}
