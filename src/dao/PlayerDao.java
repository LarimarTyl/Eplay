package dao;

import bean.PlayerBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:21
 */
public interface PlayerDao {
    public boolean savePlayer(PlayerBean player);//保存用户信息
    public boolean delPlayer(PlayerBean player);//删除用户信息
    public boolean updatePlayer(PlayerBean player);//更新用户信息
    public List<PlayerBean> selectAllPlayers();//查看所有的玩家信息
    public List<PlayerBean> selectPlayersByStatus(int status);//根据玩家状态查找玩家（0可接单，1待接单（下单未回复），2已经接单）
    public List<PlayerBean> selectPlayersByPrice(double price);//根据不同的价格查找玩家
    public List<PlayerBean> selectPlayersByGame(String gameName);//根据游戏名字查找玩家
    public List<PlayerBean> selectPlayersByGender(String gender);//根据段位查找玩家
    public List<PlayerBean> selectPlayersByGameAndLevel(String gameName,String level);//根据游戏名和段位等级查找玩家
    public List<PlayerBean> selectPlayersByGameAndLevelAndGender(String gameName,String level,String gender);//根据游戏名、段位、性别查找玩家
    public PlayerBean selectPlayByName(String playerName);//根据玩家名字查找玩家
    public PlayerBean selectPlayById(String playerId);//根据玩家id查找玩家
}
