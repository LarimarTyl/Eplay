package dao;

import bean.GameListBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:19
 */
public interface GameListDao {
    /**
     * 保存游戏列表信息
     * @param game 游戏列表对象（用于保存）
     * @return 返回保存的结果
     */
    public boolean saveGameList(GameListBean game);

    /**
     * 删除游戏列表信息
     * @param game 游戏列表信息（用于获取id）
     * @return 返回删除状态
     */
    public boolean delGameList(GameListBean game);

    /**
     * 更新游戏列表信息
     * @param game 游戏列表信息对象（相关内容可以再对象里改再更新）
     * @return 返回更新状态
     */
    public boolean updateGameList(GameListBean game);

    /**
     * 查询所有游戏
     * @return 返回所有游戏的集合
     */
    public List<GameListBean> selectAllGames();

    /**
     * 根据游戏名查询游戏
     * @param gameName 游戏名
     * @return 返回查询到的游戏对象
     */
    public GameListBean selectAllGameByName(String gameName);

    /**
     * 根据游戏id查询游戏
     * @param id 游戏id
     * @return 返回查询到的游戏对象
     */
    public GameListBean selectAllGameByid(int id);
}
