package dao.impl;

import bean.PlayerBean;
import dao.PlayerDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * Create by czq
 * time on 2019/7/25  9:04
 */
public class PlayerDaoimpl implements PlayerDao {
    QueryRunner qr;

    public PlayerDaoimpl() {
        qr = new QueryRunner(C3P0Util.getDs());
    }

    @Override
    public boolean savePlayer(PlayerBean player) {
        return false;
    }

    @Override
    public boolean delPlayer(PlayerBean player) {
        return false;
    }

    @Override
    public boolean updatePlayer(PlayerBean player) {
        return false;
    }

    @Override
    public List<PlayerBean> selectAllPlayers() {
        return null;
    }

    @Override
    public List<PlayerBean> pageAllPlayers(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public List<PlayerBean> selectPlayersByStatus(int status) {
        return null;
    }

    @Override
    public List<PlayerBean> pagePlayersByStatus(int status, int currentPage, int pageSize) {
        return null;
    }

    @Override
    public List<PlayerBean> selectPlayersByPrice(double price) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and player.money=?";
        List<PlayerBean> players = null;
        try {
            players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<PlayerBean> pagePlayersByPrice(double price, int currentPage, int pageSize) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and player.money=? limit ?,?";
        List<PlayerBean> players = null;
        try {
            players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), price, (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<PlayerBean> selectPlayersByGame(String gameName) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and gamelist.gameName=?;";
        List<PlayerBean> players = null;
        try {
            players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), gameName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<PlayerBean> pagePlayersByGame(String gameName, int currentPage, int pageSize) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and gamelist.gameName=? limit ?,?";
        List<PlayerBean> players = null;
        try {
            players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), gameName, (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<PlayerBean> selectPlayersByGender(String gender) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and `user`.gender=?";
        List<PlayerBean> players = null;
        try {
            players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<PlayerBean> pagePlayersByGender(String gender, int currentPage, int pageSize) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and `user`.gender=? limit ?,?";
        List<PlayerBean> players = null;
        try {
            players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), gender, (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<PlayerBean> selectPlayersByGameAndLevel(String gameName, String level) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and gamelist.gameName=? and level.gameLeve=?";
        List<PlayerBean> players = null;
        try {
            players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), gameName, level);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<PlayerBean> pagePlayersByGameAndLevel(String gameName, String level, int currentPage, int pageSize) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and gamelist.gameName=? and level.gameLeve=? limit ?,?";
        List<PlayerBean> players = null;
        try {
            players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), gameName, level, (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<PlayerBean> selectPlayersByGameAndLevelAndGender(String gameName, String level, String gender) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and gamelist.gameName=? and level.gameLeve=? and user.gender=?";
        List<PlayerBean> players = null;
        try {
            players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), gameName, level,gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<PlayerBean> pagePlayersByGameAndLevelAndGender(String gameName, String level, String gender, int currentPage, int pageSize) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and gamelist.gameName=? and level.gameLeve=? and user.gender=? limit ?,?";
        List<PlayerBean> players = null;
        try {
            players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), gameName, level,gender,(currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public PlayerBean selectPlayByName(String playerName) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and user.staffName=?";
        PlayerBean player = null;
        try {
            player = qr.query(sql, new BeanHandler<>(PlayerBean.class), playerName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    @Override
    public PlayerBean selectPlayById(int playerId) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and player.playerID=?";
        PlayerBean player = null;
        try {
            player = qr.query(sql, new BeanHandler<>(PlayerBean.class), playerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }
}
