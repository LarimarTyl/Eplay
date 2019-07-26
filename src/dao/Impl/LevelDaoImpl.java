package dao.Impl;

import bean.LevelBean;
import dao.LevelDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * Create by mysteriousTime
 * time on 2019/7/25  15:56
 */
public class LevelDaoImpl implements LevelDao {
    QueryRunner qr;

    public LevelDaoImpl() {
        qr = new QueryRunner(C3P0Util.getDs());
    }

    @Override
    public boolean saveLevel(LevelBean level) {
        boolean flag = false;
        String sql_1 = "insert into level value (?,?,?)";
        int a = 0;
        try {
            a = qr.update(sql_1, level.getId(), level.getGameID(), level.getGameName());
//            b = qr.update(sql_2, 7,gameName);
            if (a != 0) {
                flag = true;
                System.out.println("是否插入数据：" + flag);
            }
        } catch (SQLException e) {
            System.out.println("保存游戏等级失败" + e.getMessage());
        }

        return flag;
    }

    @Override
    public boolean delLevel(LevelBean level) {
        boolean flag = false;
        String sql_1 = "delete from level where id=?";
        try {
            int a = qr.update(sql_1, level.getId());
            if (a != 0) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("删除等级失败：" + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean updateLevel(LevelBean level) {
        boolean flag = false;
        String sql = "update level set gameid=?,gameleve=? where id=? ";
        try {
            int a = qr.update(sql, level.getGameID(), level.getGameLeve(), level.getId());
            if (a != 0) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("修改等级表失败：" + e.getMessage());
        }
        return flag;
    }

    @Override
    public List<LevelBean> selectLevelsByName(String gameName) {//查询某个游戏的等级段位
        List<LevelBean> list;
        String sql = "select level.gameleve from level,gamelist where level.id=gamelist.id and gamelist.gameName=? ";
        try {
            list = qr.query(sql, new BeanListHandler<>(LevelBean.class), gameName);
            if (list != null) {
                System.out.println(list);
                return list;
            }
        } catch (SQLException e) {
            System.out.println("//查询某个游戏的等级段位：" + e.getMessage());
        }
        return null;
    }
}
