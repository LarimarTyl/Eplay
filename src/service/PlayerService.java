package service;

import bean.PlayerBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 17:17
 */
public interface PlayerService {
    public List<PlayerBean> listAllPlayers();//检索所有玩家
    public List<PlayerBean> listPlayersByGameName(String name);//根据游戏名称检索玩家
    public List<PlayerBean> listPlayersByLevel(String level);//根据段位检索玩家
    public List<PlayerBean> listPlayersByGender(String gender);//根据性别检索玩家
    public List<PlayerBean> listPlayersByGameAndLevel(String name,String level);//根据游戏名和段位检索玩家
    public List<PlayerBean> listPlayersByGameAndLevelAndGender(String name,String level,String gender);//根据游戏、段位、性别检索玩家
    public PlayerBean getPlayerInfo(int playerId);//陪玩详细信息
}
