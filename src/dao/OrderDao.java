package dao;

import bean.OrderBean;

import java.util.Date;
import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:20
 */
public interface OrderDao {
    public boolean saveOrder(OrderBean order);
    public boolean delOrder(OrderBean order);
    public boolean upDateOrder(OrderBean order);
    public  OrderBean selectOrderById(int id);//根据订单id查找订单
    public List<OrderBean> selectAllOrders();//查询所有订单
    public List<OrderBean> selectOrdersByUser(String userName);//查询某个用户 的订单
    public List<OrderBean> selectOrdersByPlayer(String player);//查询某个玩家的订单
    public List<OrderBean> selectOrdersByGame(String GameName);//查询某个游戏相关的订单
    public List<OrderBean> selectOrdersByDate(Date date);//查询某个日期的订单
    public List<OrderBean> selectOrdersByPayWay(int payway);//查询特定支付方式的订单
    public List<OrderBean> selectOrdersByPoints(int points);//查询特订评分的订单
}
