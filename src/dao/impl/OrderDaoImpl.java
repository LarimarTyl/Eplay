package dao.impl;

import bean.OrderBean;
import dao.OrderDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;
import util.Constant;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/25 星期四 10:44
 */
public class OrderDaoImpl implements OrderDao {
    private static QueryRunner qr = new QueryRunner(C3P0Util.getDs());

    /**
     * 保存订单
     * @param order 订单对象
     * @return 返回订单保存状态
     */
    @Override
    public boolean saveOrder(OrderBean order) {
        String sql = "INSERT INTO orders (gameID, userID, playerID, contact, starttime, endtime, price, payway, appraise, remark) values (?,?,?,?,?,?,?,?,?,?,?)";
        Object o[]={order.getGameID(),order.getUserID(),order.getPlayerID(),order.getContact(),order.getStarttime(),order.getEndtime(),order.getPrice(),order.getPayWay(),order.getAppraise(),order.getRemark()};
        try {
            int save = qr.update(sql, o);
            if (save>0){
                System.out.println("保存用户成功");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("保存用户失败");
        return false;
    }

    /**
     * 删除订单
     * @param order 订单对象
     * @return 返回订单删除状态
     */
    @Override
    public boolean delOrder(OrderBean order) {
        String sql = "delete from orders where id = ?";
        try {
            int del = qr.update(sql, order.getId());
            if (del>0){
                System.out.println("删除成功");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("删除失败");
        return false;
    }

    /**
     * 更改订单信息
     * @param order 订单对象
     * @return 返回更新状态
     */
    @Override
    public boolean upDateOrder(OrderBean order) {
        String sql = "update orders set gameID=?,contact=?,price=?,payway=?,poitns=?,appraise=?,remark=?,status=?";
        Object[]o={order.getGameID(),order.getContact(),order.getPrice(),order.getPayWay(),order.getPoitns(),order.getAppraise(),order.getRemark(),order.getStatus()};
        try {
            int update = qr.update(sql, o);
            if (update>0){
                System.out.println("更新成功！");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("更新失败");
        return false;
    }

    /**
     * 根据订单id查找订单
     * @param id 订单id
     * @return 返回该订单
     */
    @Override
    public OrderBean selectOrderById(int id) {
//        String sql = "select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id";
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having orders.id=?";
        try {
            OrderBean aimOrder = qr.query(sql, new BeanHandler<OrderBean>(OrderBean.class),id);
            if (aimOrder!=null) {
                System.out.println("查询到了该数据。");
                System.out.println(aimOrder.toString());
                return aimOrder;
            }else {
                System.out.println("没有查到该id对应的数据。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            System.out.println("查询失败");
        return null;
    }

    /**
     * 查询所有订单
     * @return 返回所有订单信息
     */
    @Override
    public List<OrderBean> selectAllOrders() {

        String sql = "select orders.id,\n" +
                "       playerinfo.gameID,\n" +
                "       playerinfo.gameName,\n" +
                "       userID,\n" +
                "       user.staffName,\n" +
                "       orders.playerID,\n" +
                "       playerinfo.staffName as playerName,\n" +
                "       contact,\n" +
                "       payway,\n" +
                "       starttime,\n" +
                "       endtime,\n" +
                "       orders.price,\n" +
                "       poitns,\n" +
                "       appraise,\n" +
                "       remark,\n" +
                "       orders.status\n" +
                "from orders,\n" +
                "     user,\n" +
                "     (select player.id, playerID, staffName , player.gameID, player.level, gameName, player.money\n" +
                "      from player,\n" +
                "           user,\n" +
                "           gamelist\n" +
                "      where playerID = user.id\n" +
                "        and player.gameID = gamelist.id) as playerinfo\n" +
                "where playerinfo.id = orders.playerID\n" +
                "  and userID = user.id";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class));
            if (query.size()>0){
                System.out.println("查到了数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错检查代码");
        return null;
    }

    /**
     * 分页查询所有订单
     * @param currentPage 当前页面
     * @param pageSize 页面大小
     * @return 返回分页后的订单数据
     */
    @Override
    public List<OrderBean> pageAllOrders(int currentPage, int pageSize) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id limit ?,?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),(currentPage-1)*pageSize,pageSize);
            if (query.size()>0){
                System.out.println("查到了数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错检查代码");
        return null;
    }

    /**
     * 查询某个用户的订单
     * @param userName 用户名
     * @return 返回该用户名对应的所有订单
     */
    @Override
    public List<OrderBean> selectOrdersByUser(String userName) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id and staffName=?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),userName);
            if (query.size()>0){
                System.out.println("查到了该用户的数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到该用户的数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }

    /**
     * 分页查询某个用户的订单
     * @param userName 用户名
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 返回分页后该用户的订单
     */
    @Override
    public List<OrderBean> pageOrdersByUser(String userName, int currentPage, int pageSize) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id and staffName=? limit ?,?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),userName,(currentPage-1)*pageSize,pageSize);
            if (query.size()>0){
                System.out.println("查到了该用户的数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到该用户的数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }

    /**
     * 查询某个玩家的订单
     * @param player 玩家对象
     * @return 返回该玩家对应的所有订单
     */
    @Override
    public List<OrderBean> selectOrdersByPlayer(String player) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having playerName=?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),player);
            if (query.size()>0){
                System.out.println("查到了该玩家的订单数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到该玩家的订单数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }

    /**
     * 分页查询某个玩家的订单
     * @param player 玩家对象
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 返回分页后该玩家对应的所有订单
     */
    @Override
    public List<OrderBean> pageOrdersByPlayer(String player, int currentPage, int pageSize) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having playerName=? limit ?,?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),player,(currentPage-1)*pageSize,pageSize);
            if (query.size()>0){
                System.out.println("查到了该玩家的订单数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到该玩家的订单数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }

    /**
     * 查询某个游戏相关的订单
     * @param GameName 游戏名
     * @return 返回某个游戏对应的订单
     */
    @Override
    public List<OrderBean> selectOrdersByGame(String GameName) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having playerinfo.gameName=?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),GameName);
            if (query.size()>0){
                System.out.println("查到了该游戏的订单数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到该游戏的订单数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }

    /**
     * 分页查询某个游戏相关的订单
     * @param GameName 游戏名
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 返回分页后某游戏对应的订单
     */
    @Override
    public List<OrderBean> pageOrdersByGame(String GameName, int currentPage, int pageSize) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having playerinfo.gameName=? limit ?,?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),GameName,(currentPage-1)*pageSize,pageSize);
            if (query.size()>0){
                System.out.println("查到了该游戏的订单数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到该游戏的订单数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }


    /**
     * 查询某个日期的订单
     * @param date 日期
     * @return 返回某个日期之前的订单
     */
    @Override
    public List<OrderBean> selectOrdersByDate(String date) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having starttime<=?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),date);
            if (query.size()>0){
                System.out.println("查到了该日期之前的订单数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到该日期之前的订单数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }


    /**
     * 分页查询某个日期的订单
     * @param date 日期
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 返回分页查询某个日期之前的订单集合
     */
    @Override
    public List<OrderBean> pageOrdersByDate(String date, int currentPage, int pageSize) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having starttime<=? limit ?,?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),date,(currentPage-1)*pageSize,pageSize);
            if (query.size()>0){
                System.out.println("查到了该日期之前的订单数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到该日期之前的订单数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }

    /**
     * 查询特定支付方式的订单
     * @param payway 支付方式
     * @return 返回特定支付方式的订单集合
     */
    @Override
    public List<OrderBean> selectOrdersByPayWay(int payway) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having payway=?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),payway);
            if (query.size()>0){
                System.out.println("查到了该支付方式的订单数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到该支付方式的订单数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }

    /**
     * 分页查询特定支付方式的订单
     * @param payway 支付方式
     * @param currentPage 当前页面
     * @param pageSize 页面大小
     * @return 返回分页查询特定支付方式的订单
     */
    @Override
    public List<OrderBean> pageOrdersByPayWay(int payway, int currentPage, int pageSize) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having payway=? limit ?,?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),payway,(currentPage-1)*pageSize,pageSize);
            if (query.size()>0){
                System.out.println("查到了该支付方式的订单数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到该支付方式的订单数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }

    /**
     * 查询大于某评分的订单
     * @param points 评分（默认6）
     * @return 返回大于给定评分的订单集合
     */
    @Override
    public List<OrderBean> selectOrdersByPoints(int points) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having poitns>?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),points);
            if (query.size()>0){
                System.out.println("查到了评分高于该值的订单数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到评分高于该值的订单数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }

    /**
     * 分页查询特订评分的订单
     * @param points 评分（默认6）
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 返回分页查询大于给定评分的订单
     */
    @Override
    public List<OrderBean> pageOrdersByPoints(int points, int currentPage, int pageSize) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=orders.playerID and userID=user.id having poitns>? limit ?,?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),points,(currentPage-1)*pageSize,pageSize);
            if (query.size()>0){
                System.out.println("查到了评分高于该值的订单数据");
                System.out.println(query);
                return query;
            }else {
                System.out.println("没查到评分高于该值的订单数据");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错，检查代码。");
        return null;
    }

    /**
     * 查询高收入玩家订单信息
     * @return 高收入玩家订单集合
     */
    @Override
    public List<OrderBean> selectTopPrice() {
        String sql="select o.id,sum(o.price) as price,playerinfo.gameID,playerinfo.gameName,userID,staffName,o.playerID,playerName,contact,payway,starttime,endtime,o.price,poitns,appraise,remark from orders as o,user," +
                "(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist " +
                "where playerID=user.id and player.gameID=gamelist.id) as playerinfo where playerinfo.id=o.playerID and userID=user.id and o.status=1 group by o.playerID limit  ?,?";
        List<OrderBean> result;
        try {
            result= qr.query(sql,new BeanListHandler<OrderBean>(OrderBean.class) , Constant.DEFAULT_MIN_RECORD, Constant.DEFAULT_MAX_RECORD);
            if(result.size()>=0){
                return result;
            }else{
                System.out.println("查询高收入有错");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询高订单数玩家订单
     * @return 高订单数玩家订单集合
     */
    @Override
    public List<OrderBean> selectTopOrder() {
        String sql="select o.id,count(o.id) as count,playerinfo.gameID,playerinfo.gameName,userID,staffName,o.playerID,playerName," +
                "contact,payway,starttime,endtime,o.price,poitns,appraise,remark from orders as o,user," +
                "(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist " +
                "where playerID=user.id and player.gameID=gamelist.id) as playerinfo where playerinfo.id=o.playerID and userID=user.id and o.status=1 group by o.playerID limit  ?,?";
        List<OrderBean> result;
        try {
            result= qr.query(sql,new BeanListHandler<OrderBean>(OrderBean.class) , Constant.DEFAULT_MIN_RECORD, Constant.DEFAULT_MAX_RECORD);
            if(result.size()>=0){
                return result;
            }else{
                System.out.println("查询高订单,有错");
            }
        } catch (SQLException e) {
            System.out.println("语句有错"+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据订单id查找订单状态
     * @author tyl
     * @param Id
     * @return 该订单的状态
     */
    @Override
    public int getOrderStatusById(int Id) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,staffName,orders.playerID,playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo  " +
                "where playerinfo.id=orders.playerID and userID=user.id and orders.id=?";
        try {
            OrderBean query = qr.query(sql, new BeanHandler<OrderBean>(OrderBean.class));
            if (query != null) {
                System.out.println("查询到该id对应的订单");
                return query.getStatus();
            } else {
                System.out.println("该id对应的订单不存在");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询出错");
        return 0;
    }
    /**
     * 根据用户id查找对应状态的订单
     *
     * @param userId 用户id
     * @param
     * @return 找到的目标订单
     */
    @Override
    public List<OrderBean> getOrdersByUserIdAndStatus(int userId) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,orders.playerID,playerinfo.playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo  " +
                "where playerinfo.id=orders.playerID and userID=user.id and orders.userid=? and orders.status=?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<>(OrderBean.class), userId);
            if (query.size() > 0) {
                System.out.println("该用户对应状态的订单找到了");
                return query;
            } else {
                System.out.println("找不到该用户对应状态的订单");
                return query;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 根据用户id查找对应状态的订单
     * @param playId 玩家id
     * @param status 对应的订单状态
     * @return 找到的目标订单
     */

    @Override
    public List<OrderBean> getOrdersByPlayIdAndStatus(int playId, int status) {
        String sql = "select orders.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,orders.playerID,playerinfo.playerName,contact,payway,starttime,endtime,orders.price,poitns,appraise,remark,orders.status" +
                " from orders,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo  " +
                "where playerinfo.id=orders.playerID and userID=user.id and orders.playerid=? and orders.status=?";
        try {
            List<OrderBean> query = qr.query(sql, new BeanListHandler<>(OrderBean.class), playId, status);
            if (query.size() > 0) {
                System.out.println("该用户对应状态的订单找到了");
                return query;
            } else {
                System.out.println("找不到该用户对应状态的订单");
                return query;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
