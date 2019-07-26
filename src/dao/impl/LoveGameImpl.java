package dao.impl;

import bean.LoveGameBean;
import dao.LoveGameDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/26 星期五 0:12
 */
public class LoveGameImpl implements LoveGameDao {
    private static QueryRunner qr = new QueryRunner(C3P0Util.getDs());
    @Override
    public boolean addLoveGame(String username, LoveGameBean loveGame) {
        String sql = "insert into lovegame (id, userID, gameID) VALUES (?,?,?)";
        try {
            int add = qr.update(sql, loveGame.getId(), loveGame.getUserID(), loveGame.getGameID());
            if (add>0) {
                System.out.println("保存游戏爱好成功");
                return true;
            }else {
                System.out.println("保存游戏爱好失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("语句有问题,请重新输入");
        return false;
    }

    @Override
    public boolean delLoveGame(String username, LoveGameBean loveGame) {
        String sql = "delete from lovegame where userID=? and  gameID=?";
        try {
            int del = qr.update(sql, loveGame.getUserID(), loveGame.getGameID());
            if (del>0) {
                System.out.println("删除游戏爱好成功");
                return true;
            }else {
                System.out.println("删除游戏爱好失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("语句有问题,请重新输入");
        return false;
    }

    @Override
    public boolean upDateLoveGame(String username, LoveGameBean loveGame) {
        String sql = "update lovegame set gameID=? where userID=?";
        try {
            int update = qr.update(sql, loveGame.getGameID(), loveGame.getUserID());
            if (update>0){
                System.out.println("更新用户信息成功");
                return true;
            }else {
                System.out.println("更新用户信息失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("语句错误");
        return false;
    }

    @Override
    public List<LoveGameBean> selectLoveGames(String username) {
        String sql = "select lovegame.id,userID,staffName,gameID,gameName from lovegame,user,gamelist where userID=user.id and  gameID=gamelist.id";
        try {
            List<LoveGameBean> query = qr.query(sql, new BeanListHandler<LoveGameBean>(LoveGameBean.class));
            if (query.size()>0) {
                System.out.println("查询游戏偏好信息成功");
                return query;
            }else {
                System.out.println("没有找到该用户的游戏偏好设置");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("查询游戏偏好设置失败，请检查语句");
        return null;
    }
}
