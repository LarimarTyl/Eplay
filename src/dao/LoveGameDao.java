package dao;

import bean.LoveGameBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:20
 */
public interface LoveGameDao {
    public boolean addLoveGame(String username,LoveGameBean loveGame);
    public boolean delLoveGame(String username,LoveGameBean loveGame);
    public boolean upDateLoveGame(String username,LoveGameBean loveGame);
    public List<LoveGameDao> selectLoveGames(String username);//查询某个用户的关注游戏列表
}
