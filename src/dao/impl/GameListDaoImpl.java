package dao.impl;

import bean.GameListBean;

import dao.GameListDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * Create by mysteriousTime
 * time on 2019/7/26  9:43
 */
public class GameListDaoImpl implements GameListDao {
    private static  QueryRunner qr;
    public GameListDaoImpl() {
        qr = new QueryRunner(C3P0Util.getDs());
    }

    /**
     * @param game 游戏列表对象（用于保存）
     * @return 保存状态
     */
    @Override
    public boolean saveGameList(GameListBean game) {
        boolean flag = false;
        String sql_1 = "insert into gamelist value (?,?,?)";
        int a = 0;
        try {
            a = qr.update(sql_1, game.getId(), game.getGameName(), game.getGameLogo());
//            b = qr.update(sql_2, 7,gameName);
            if (a != 0) {
                flag = true;
                System.out.println("是否插入数据：" + flag);
            }
        } catch (SQLException e) {
            System.out.println("保存游戏列表失败" + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean delGameList(GameListBean game) {
        boolean flag = false;
        String sql_1 = "delete from gamelist where id=?";
        try {
            int a = qr.update(sql_1, game.getId());
            if (a != 0) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("删除游戏list失败：" + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean updateGameList(GameListBean game) {
        boolean flag = false;
        String sql = "update gamelist set gameName=?,gamelogo=? where id=? ";
        try {
            int a = qr.update(sql, game.getGameName(), game.getGameLogo(), game.getId());
            if (a != 0) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("修改游戏列表失败：" + e.getMessage());
        }
        return flag;
    }

    @Override
    public List<GameListBean> selectAllGames() {
        List<GameListBean> list;
        String sql="select id, gamelist.gamename,gameLogo from gamelist";
        try {
            list=qr.query(sql, new BeanListHandler<>(GameListBean.class));
            if (list!=null){
                System.out.println(list);
                return list;
            }
        } catch (SQLException e) {
            System.out.println("查询所有游戏失败："+e.getMessage());
        }
        return null;
    }

    @Override
    public GameListBean selectAllGameByName(String gameName) {
        GameListBean gamelist;
        String sql="select * from gamelist where gamename=?";
        try {
            gamelist= qr.query(sql,new BeanHandler<>(GameListBean.class),gameName);
            if (gamelist!=null){
                System.out.println(gamelist);
                return gamelist;
            }
        } catch (SQLException e) {
            System.out.println("selectAllGameByName失败："+e.getMessage());
        }
        return null;
    }

    @Override
    public GameListBean selectAllGameByid(int id) {
        GameListBean gamelist;
        String sql="select * from gamelist where id=?";
        try {
            gamelist= qr.query(sql,new BeanHandler<>(GameListBean.class),id);
            if (gamelist!=null){
                System.out.println(gamelist);
                return gamelist;
            }
        } catch (SQLException e) {
            System.out.println("selectAllGameByid失败："+e.getMessage());
        }
        return null;
    }
}
