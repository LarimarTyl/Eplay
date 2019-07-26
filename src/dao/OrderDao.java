package dao;

import bean.OrderBean;

import java.util.Date;
import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:20
 */
public interface OrderDao {
    /**
     * @param order 订单对象
     * @return
     */
    public boolean saveOrder(OrderBean order);
    public boolean delOrder(OrderBean order);
    public boolean upDateOrder(OrderBean order);
    public  OrderBean selectOrderById(int id);//根据订单id查找订单
    public List<OrderBean> selectAllOrders();//查询所有订单
    public List<OrderBean> pageAllOrders(int currentPage,int pageSize);//分页查询所有订单
    public List<OrderBean> selectOrdersByUser(String userName);//查询某个用户 的订单
    public List<OrderBean> pageOrdersByUser(String userName,int currentPage,int pageSize);//分页查询某个用户 的订单
    public List<OrderBean> selectOrdersByPlayer(String player);//查询某个玩家的订单
    public List<OrderBean> pageOrdersByPlayer(String player,int currentPage,int pageSize);//分页查询某个玩家的订单
    public List<OrderBean> selectOrdersByGame(String GameName);//查询某个游戏相关的订单
    public List<OrderBean> pageOrdersByGame(String GameName,int currentPage,int pageSize);//分页查询某个游戏相关的订单
    public List<OrderBean> selectOrdersByDate(String date);//查询某个日期的订单
    public List<OrderBean> pageOrdersByDate(String date,int currentPage,int pageSize);//查询某个日期的订单
    public List<OrderBean> selectOrdersByPayWay(int payway);//查询特定支付方式的订单
    public List<OrderBean> pageOrdersByPayWay(int payway,int currentPage,int pageSize);//查询特定支付方式的订单
    public List<OrderBean> selectOrdersByPoints(int points);//查询特订评分的订单
    public List<OrderBean> pageOrdersByPoints(int points,int currentPage,int pageSize);//查询特订评分的订单
}
