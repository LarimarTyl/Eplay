package service;

import bean.OrderBean;
import bean.PlayerBean;
import bean.UserBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 17:16
 */
public interface UserService {
    public boolean regiser(String name, String passWord, String phone, String qq, String code);//注册

    public boolean login(String name, String passWord, String code);//登录

    public boolean takeOrder(UserBean user, PlayerBean player, OrderBean order);//下单

    public boolean addMyOrder(OrderBean order);//下单

    public boolean delOrder(OrderBean order);//下单

    public boolean comment(OrderBean order);//评论

    public boolean recharge();//充值

    public boolean addFocous();//添加关注

    public boolean removeFocous();//移除关注

    public List<OrderBean> selectOrders();//查看订单（消费）用户消费

    public List<OrderBean> selectIncome();//查看收入（收入）玩家收入

    public boolean changePsw();//更改密码

    public boolean bePlayer();//入驻成为玩家

    public boolean modefyInfo(UserBean user);//修改用户信息


    public boolean addLoveGames();//添加游戏偏好

    public boolean removeLoveGames();//移除游戏偏好

    public boolean addBlackList();//添加黑名单

    public boolean removeBlackList();//移除黑名单


}
