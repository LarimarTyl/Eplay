package service;

import bean.OrderBean;
import bean.RechargeBean;
import bean.RelationshipBean;
import bean.UserBean;
import bean.*;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 17:16
 */
public interface UserService {
    /**
     * 注册业务
     *
     * @param register 注册对象（userBean）
     * @param code     注册码
     * @return 返回注册状态
     */
    public boolean register(UserBean register, String code);

    /**
     * 判断用户是否激活
     *
     * @param register 注册对象（userBean）
     * @return 返回是否激活
     */
    public boolean isActive(UserBean register);

    /**
     * 判断用户是否存在
     *
     * @param register 注册对象（userBean）
     * @return 返回是否存在
     */
    public boolean isExcit(UserBean register);

    /**
     * 登录验证
     *
     * @param name     用户名或登录名
     * @param passWord 密码
     * @param code     验证码
     * @return 返回登录状态
     */
    public boolean login(String name, String passWord, String code);

    /**
     * 用户下单业务
     *
     * @param user   下单用户
     * @param player 接单玩家
     * @param order  订单对象
     * @return 返回下单状态
     */
    public boolean takeOrder(UserBean user, PlayerBean player, OrderBean order);

    /**
     * 删除订单
     *
     * @param order 订单对象
     * @return 返回删除订单状态
     */
    public boolean delOrder(OrderBean order);

    /**
     * 接受（添加）订单
     *
     * @param order 订单对象
     * @return 返回添加订单状态
     */
    public boolean addMyOrder(OrderBean order);


    public OrderBean queryOrderById(int id);

    /**
     * 评论
     * 评论只能再下单后进行（添加修改订单内的评分和评论两个字段）
     *
     * @param order 订单对象
     * @return 返回评论（修改）状态
     */
    public boolean comment(OrderBean order);

    /**
     * 充值业务
     *
     * @param recharge      充值对象
     * @param userBean      充值用户
     * @param rechargeMoney 充值金额
     * @return 返回充值状态是否成功
     */
    public boolean recharge(RechargeBean recharge, UserBean userBean, double rechargeMoney);

    /**
     * 添加关注
     *
     * @param staffName        用户名
     * @param relationshipBean 关系对象
     * @return 返回添加状态
     */
    public boolean addFocous(String staffName, RelationshipBean relationshipBean);

    /**
     * 移除关注
     *
     * @param staffName        用户名
     * @param relationshipBean 关系对象
     * @return 返回移除状态
     */
    public boolean removeFocous(String staffName, RelationshipBean relationshipBean);

    /**
     * 查看订单（消费）用户消费
     * 这个订单是指用户下单消费的订单
     *
     * @param userName 用户名
     * @return 返回订单集合
     */
    public List<OrderBean> selectOrders(String userName);


    /*
    根据玩家id和状态返回被陪玩接收的订单
     */

    public List<OrderBean> selectOrdersByPlayId(int playid, int status);


    /**
     * 查看收入（收入）玩家收入
     * 这个订单是指玩家接单收入的订单
     *
     * @param player 玩家名
     * @return 返回订单集合对象
     */
    public List<OrderBean> selectIncome(String player);

    /**
     * 修改密码
     *
     * @param userBean 用户对象
     * @return 返回密码修改状态
     */
    public boolean changePsw(UserBean userBean);

    /**
     * 申请入驻成为玩家
     *
     * @param userBean   用户对象（关联用户和玩家表）
     * @param playerBean 玩家对象（生成新的玩家表对象，等待审核修改）
     * @return 返回申请结果
     */
    public boolean bePlayer(UserBean userBean, PlayerBean playerBean);

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return 返回修改结果
     */
    public boolean modefyInfo(UserBean user);

    /**
     * 添加游戏偏好
     *
     * @param loveGameBean 喜好游戏对象
     * @return 返回添加状态
     */
    public boolean addLoveGames(LoveGameBean loveGameBean);

    /**
     * 移除游戏偏好
     *
     * @param loveGameBean 喜好游戏对象
     * @return 返回移除状态
     */
    public boolean removeLoveGames(LoveGameBean loveGameBean);

    /**
     * 添加黑名单
     *
     * @param relationshipBean 关系表对象
     * @return 返回添加状态
     */
    public boolean addBlackList(RelationshipBean relationshipBean);

    /**
     * 移除黑名单
     *
     * @param relationshipBean 关系对象
     * @return 移除黑名单状态
     */
    public boolean removeBlackList(RelationshipBean relationshipBean);


    /**
     * 根据id放回对应消息的对象
     *
     * @param id
     * @return
     */
    public MessageBean queryMessage(int id);


    /**
     * 根据用户id返回该用户的所有消息
     */
    public List<MessageBean> queryMessageListByUserId(int userId);

    /**
     * 根据用户id和状态放回对应的消息
     */

    public List<MessageBean> queryMessageListByUserIdAndSatus(int userId, int status);


    /**
     * 根据用户名查找该用户的所有信息
     */
    public List<MessageBean> queryMessageListByUserName(String username);


    /**
     * 根据用户名和状态查找该用户的所有信息
     */
    public List<MessageBean> queryMessageListByUserNameAndStatus(String username, int status);


    /**
     * 更新消息
     */
    public void updateMessage(MessageBean message);

    /**
     * 删除消息
     */
    public void deleteMessage(MessageBean message);

}
