package dao.impl;

import bean.OrderBean;
import bean.PlayerBean;
import dao.PlayerDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by czq
 * time on 2019/7/25  9:04
 */
public class PlayerDaoImpl implements PlayerDao {
    QueryRunner qr;

    public PlayerDaoImpl() {
        qr = new QueryRunner(C3P0Util.getDs());
    }

    @Override
    public boolean savePlayer(PlayerBean player) {//保存用户信息
        boolean flag = false;
        String sql = "insert into player values (?,?,?,?,?,?,?,?,?) ";
        try {
            int update = qr.update(sql, player.getId(), player.getPlayerID(),
                    player.getGameID(), player.getGameLeve(),
                    player.getPicPath(), player.getOrderNum(), player.getMoney(),
                    player.getIntroduce(), player.getStatus());

            if (update != 0) {
                flag = true;
            }
        } catch (SQLException e) {
            System.out.println("保存用户失败："+e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean delPlayer(PlayerBean player) {//删除用户
        boolean flag = false;
        String sql="delete from player where id=?";
        try {
            int a=qr.update(sql,player.getId());
            if (a!=0){
                flag=true;
            }
        } catch (SQLException e) {
            System.out.println("删除用户失败："+e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean updatePlayer(PlayerBean player) {//更新用户信息
        boolean flag=false;
        String sql="update player set picPath=?,orderNum=?,money=?,introduce=?,status=? where id=?";
        try {
            int a=qr.update(sql,player.getPicPath(),player.getOrderNum(),player.getMoney(),player.getIntroduce(),player.getStatus(),player.getId());
            if (a!=0){
                System.out.println("更改成功");
                flag=true;
            }
        } catch (SQLException e) {
            System.out.println("修改用户信息失败："+e.getMessage());
        }
        System.out.println(flag);
        return flag;

    }
    /**
     * 查看所有用户信息
     */

    @Override
    public List<PlayerBean> selectAllPlayers() {
        List<PlayerBean> list;
        String sql="select p.id,p.playerID,staffName,p.gameID,p.level,g.gameName,u.photoPath,u.gender,p.picPath,l.gameLeve as gameLeve,p.orderNum,p.money,p.introduce,p.status from player as p,user as u,level as l,gamelist as g where p.gameID=g.id and l.id=p.level and l.gameID=g.id and p.playerID=u.id";
        try {
            list = qr.query(sql, new BeanListHandler<PlayerBean>(PlayerBean.class));
            if (list!=null){
                System.out.println("查询所有用户信息！");
                System.out.println(list);
                return list;
            }
        } catch (SQLException e) {
            System.out.println("查看所有用户信息失败"+e.getMessage());
        }
        System.out.println("查询所有用户信息失败！");
        return null;
    }
    /*
     * 分页查询
     * */
    @Override
    public List<PlayerBean> pageAllPlayers(int currentPage, int pageSize) {
        PlayerBean player;
        List<PlayerBean> list=new ArrayList<>();
        String sql="SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level`ORDER BY player.id LIMIT ?, ?";
        try {
            player=qr.query(sql,new BeanHandler<>(PlayerBean.class),(currentPage-1)*pageSize,pageSize);
            if (player!=null){
                list.add(player);
                System.out.println("添加分页成功");
                return list;
            }

        } catch (SQLException e) {
            System.out.println("分页查询"+e.getMessage());
        }

        return null;
    }

    @Override
    public List<PlayerBean> selectPlayersByStatus(int status) {
        PlayerBean player;
        List<PlayerBean> list=new ArrayList<>();
        String sql="SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and player.`status`=?";
        try {
            player=qr.query(sql,new BeanHandler<>(PlayerBean.class),status);
            if (player!=null){
                list.add(player);
                System.out.println("根据状态查询成功");
                return list;
            }
        } catch (SQLException e) {
            System.out.println("根据状态查询失败："+e.getMessage());
        }
        return null;
    }

    @Override
    public List<PlayerBean> pagePlayersByStatus(int status, int currentPage, int pageSize) {
        PlayerBean player;
        List<PlayerBean> list=new ArrayList<>();
        String sql="SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and player.`status`=? limit  ?,?";
        try {
            player=qr.query(sql,new BeanHandler<>(PlayerBean.class),status,(currentPage-1)*pageSize,pageSize);
            if (player!=null){
                list.add(player);
                System.out.println("根据状态分页查询成功");
                return list;
            }
        } catch (SQLException e) {
            System.out.println("根据状态分页查询失败："+e.getMessage());
        }
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

        try {
            List<PlayerBean>   players = qr.query(sql, new BeanListHandler<>(PlayerBean.class), gameName);
            return players;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
        String sql="select p.id,p.playerID,u.staffName,p.gameID,p.level,g.gameName,u.photoPath,u.gender,p.picPath,l.gameLeve as gameLeve,p.orderNum,p.money,p.introduce,p.status from player as p,user as u,level as l,gamelist as g where p.gameID=g.id and l.id=p.level and l.gameID=g.id and p.playerID=u.id and p.id=?";
        PlayerBean player = null;
        try {
            player = qr.query(sql, new BeanHandler<>(PlayerBean.class), playerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    @Override
    public List<PlayerBean> selectNewPlayers() {
        String sql="select p.id,p.playerID,u.staffName,p.gameID,p.level,g.gameName,u.photoPath,u.gender,p.picPath,l.gameLeve as gameLeve,p.orderNum,p.money,p.introduce,p.status from player as p,user as u,level as l,gamelist as g where p.gameID=g.id and l.id=p.level and l.gameID=g.id and p.playerID=u.id order by p.id desc limit 7";
        try {
            List<PlayerBean> query = qr.query(sql, new BeanListHandler<PlayerBean>(PlayerBean.class));
            if (query.size()>0){
                System.out.println("查询到新秀玩家");
                System.out.println(query);
                return  query;
            }else {
                System.out.println("没有查到新秀玩家");
                return  null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public int selectPlayerStatus(int id) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,gameLeve,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and player.playerID=?";
        try {
            PlayerBean query = qr.query(sql, new BeanHandler<PlayerBean>(PlayerBean.class));
            if (query!=null){
                System.out.println("查到了该玩家信息");
                return query.getStatus();
            }else {
                System.out.println("该玩家信息不存在");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<PlayerBean> selectPlayersByPlayerId(int playerId) {
        String sql = "SELECT playerID,staffName,player.gameID,`level`,gameName,photoPath,gender,picPath,player.level,orderNum,player.money,introduce,player.`status` FROM player,user,gamelist,level WHERE player.playerID=user.id and player.gameID=gamelist.id and `level`.id=player.`level` and playerID=?;";
        try {
            List<PlayerBean>   players = qr.query(sql, new BeanListHandler<>(PlayerBean.class),playerId);
            return players;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}