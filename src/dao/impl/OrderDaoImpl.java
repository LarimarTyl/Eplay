package dao.impl;

import bean.OrderBean;
import dao.OrderDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/25 星期四 10:44
 */
public class OrderDaoImpl implements OrderDao {
    private static QueryRunner qr = new QueryRunner(C3P0Util.getDs());

    @Override
    public boolean saveOrder(OrderBean order) {
        String sql = "INSERT INTO `order` (gameID, userID, playerID, contact, starttime, endtime, price, payway, appraise, remark) values (?,?,?,?,?,?,?,?,?,?)";
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

    @Override
    public boolean delOrder(OrderBean order) {
        String sql = "delete from `order` where id = ?";
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

    @Override
    public boolean upDateOrder(OrderBean order) {
        String sql = "update `order` set gameID=?,contact=?,price=?,payway=?,poitns=?,appraise=?,remark=?";
        Object[]o={order.getGameID(),order.getContact(),order.getPrice(),order.getPayWay(),order.getPoitns(),order.getAppraise(),order.getRemark()};
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

    @Override
    public OrderBean selectOrderById(int id) {
//        String sql = "select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id";
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having `order`.id=?";
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

    @Override
    public List<OrderBean> selectAllOrders() {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id";
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

    @Override
    public List<OrderBean> pageAllOrders(int currentPage, int pageSize) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id limit ?,?";
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

    @Override
    public List<OrderBean> selectOrdersByUser(String userName) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having user.staffName=?";
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

    @Override
    public List<OrderBean> pageOrdersByUser(String userName, int currentPage, int pageSize) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having user.staffName=? limit ?,?";
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

    @Override
    public List<OrderBean> selectOrdersByPlayer(String player) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having playerinfo.playerName=?";
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

    @Override
    public List<OrderBean> pageOrdersByPlayer(String player, int currentPage, int pageSize) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having playerinfo.playerName=? limit ?,?";
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

    @Override
    public List<OrderBean> selectOrdersByGame(String GameName) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having playerinfo.gameName=?";
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

    @Override
    public List<OrderBean> pageOrdersByGame(String GameName, int currentPage, int pageSize) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having playerinfo.gameName=? limit ?,?";
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

    @Override
    public List<OrderBean> selectOrdersByDate(String date) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having starttime<=?";
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

    @Override
    public List<OrderBean> pageOrdersByDate(String date, int currentPage, int pageSize) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having starttime<=? limit ?,?";
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

    @Override
    public List<OrderBean> selectOrdersByPayWay(int payway) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having payway=?";
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

    @Override
    public List<OrderBean> pageOrdersByPayWay(int payway, int currentPage, int pageSize) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having payway=? limit ?,?";
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

    @Override
    public List<OrderBean> selectOrdersByPoints(int points) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having poitns>?";
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

    @Override
    public List<OrderBean> pageOrdersByPoints(int points, int currentPage, int pageSize) {
        String sql = "select `order`.id,playerinfo.gameID,playerinfo.gameName,userID,user.staffName,`order`.playerID,playerinfo.playerName,contact,payway,starttime,endtime,`order`.price,poitns,appraise,remark" +
                " from `order`,user,(select player.id,playerID,staffName as playerName,player.gameID,player.level,gameName,player.money from player,user,gamelist where playerID=user.id and player.gameID=gamelist.id) as playerinfo " +
                "where playerinfo.id=`order`.playerID and userID=user.id having poitns>? limit ?,?";
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
}
