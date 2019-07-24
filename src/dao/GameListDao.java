package dao;

import bean.GameListBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:19
 */
public interface GameListDao {
    public boolean saveGameList(GameListBean game);
    public boolean delGameList(GameListBean game);
    public boolean updateGameList(GameListBean game);
    public List<GameListBean> selectAllGames();//查询所有游戏
    public GameListBean selectAllGameByName(String gameName);//根据游戏名查询游戏
    public GameListBean selectAllGameByid(int id);//根据游戏id查询游戏
}
