package dao;

import bean.LoveGameBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:20
 */
public interface LoveGameDao {
    /**
     * 保存某个用户的偏好游戏
     * @param username 用户名
     * @param loveGame 偏好游戏名
     * @return 返回保存状态
     */
    public boolean addLoveGame(String username,LoveGameBean loveGame);

    /**
     * 删除某个用户的游戏偏好信息
     * @param username 用户名
     * @param loveGame 偏好游戏名
     * @return 返回删除状态
     */
    public boolean delLoveGame(String username,LoveGameBean loveGame);

    /**
     * 跟新游戏偏好信息
     * @param username 用户名
     * @param loveGame 偏好游戏名
     * @return 返回更新结果
     */
    public boolean upDateLoveGame(String username,LoveGameBean loveGame);

    /**
     * 查询某个特定用户的关注游戏列表
     * @param username 用户名
     * @return 返回用户关注游戏的集合
     */
    public List<LoveGameBean> selectLoveGames(String username);
}
