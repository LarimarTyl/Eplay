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
     * 保存订单
     *
     * @param order 订单对象
     * @return 返回订单保存状态
     */
    public boolean saveOrder(OrderBean order);

    /**
     * 删除订单
     *
     * @param order 订单对象
     * @return 返回订单删除状态
     */
    public boolean delOrder(OrderBean order);

    /**
     * 更改订单信息
     *
     * @param order 订单对象
     * @return 返回更新状态
     */
    public boolean upDateOrder(OrderBean order);

    /**
     * 根据订单id查找订单
     *
     * @param id 订单id
     * @return 返回该订单
     */
    public OrderBean selectOrderById(int id);

    /**
     * 查询所有订单
     *
     * @return 返回所有订单信息
     */
    public List<OrderBean> selectAllOrders();

    /**
     * 分页查询所有订单
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return 返回分页后的订单数据
     */
    public List<OrderBean> pageAllOrders(int currentPage, int pageSize);

    /**
     * 查询某个用户的订单
     *
     * @param userName 用户名
     * @return 返回该用户名对应的所有订单
     */
    public List<OrderBean> selectOrdersByUser(String userName);

    /**
     * 分页查询某个用户的订单
     *
     * @param userName    用户名
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 返回分页后该用户的订单
     */
    public List<OrderBean> pageOrdersByUser(String userName, int currentPage, int pageSize);

    /**
     * 查询某个玩家的订单
     *
     * @param player 玩家对象
     * @return 返回该玩家对应的所有订单
     */
    public List<OrderBean> selectOrdersByPlayer(String player);

    /**
     * 分页查询某个玩家的订单
     *
     * @param player      玩家对象
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 返回分页后该玩家对应的所有订单
     */
    public List<OrderBean> pageOrdersByPlayer(String player, int currentPage, int pageSize);

    /**
     * 查询某个游戏相关的订单
     *
     * @param GameName 游戏名
     * @return 返回某个游戏对应的订单
     */
    public List<OrderBean> selectOrdersByGame(String GameName);

    /**
     * 分页查询某个游戏相关的订单
     *
     * @param GameName    游戏名
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 返回分页后某游戏对应的订单
     */
    public List<OrderBean> pageOrdersByGame(String GameName, int currentPage, int pageSize);

    /**
     * 查询某个日期的订单
     *
     * @param date 日期
     * @return 返回某个日期之前的订单
     */
    public List<OrderBean> selectOrdersByDate(String date);

    /**
     * 分页查询某个日期的订单
     *
     * @param date        日期
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 返回分页查询某个日期之前的订单集合
     */
    public List<OrderBean> pageOrdersByDate(String date, int currentPage, int pageSize);

    /**
     * 查询特定支付方式的订单
     *
     * @param payway 支付方式
     * @return 返回特定支付方式的订单集合
     */
    public List<OrderBean> selectOrdersByPayWay(int payway);

    /**
     * 分页查询特定支付方式的订单
     *
     * @param payway      支付方式
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return 返回分页查询特定支付方式的订单
     */
    public List<OrderBean> pageOrdersByPayWay(int payway, int currentPage, int pageSize);

    /**
     * 查询大于某评分的订单
     *
     * @param points 评分（默认6）
     * @return 返回大于给定评分的订单集合
     */
    public List<OrderBean> selectOrdersByPoints(int points);

    /**
     * 分页查询特订评分的订单
     *
     * @param points      评分（默认6）
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 返回分页查询大于给定评分的订单
     */
    public List<OrderBean> pageOrdersByPoints(int points, int currentPage, int pageSize);

    /**
     * 查询高收入玩家订单信息
     *
     * @return 高收入玩家订单集合
     */
    public List<OrderBean> selectTopPrice();

    /**
     * 查询高订单数玩家订单
     *
     * @return 高订单数玩家订单集合
     */
    public List<OrderBean> selectTopOrder();

    /**
     * 根据订单id查找订单状态
     *
     * @param Id
     * @return 该订单的状态
     * @author tyl
     */
    public int getOrderStatusById(int Id);

    /**
     * 根据用户id查找对应状态的订单
     *
     * @param userId 用户id
     * @param
     * @return 找到的目标订单
     */
    public List<OrderBean> getOrdersByUserIdAndStatus(int userId);

    public List<OrderBean> getOrdersByPlayIdAndStatus(int playId, int status);
}
