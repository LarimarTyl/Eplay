package dao;

import bean.LevelBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:20
 */
public interface LevelDao {
    /**
     * 保存游戏等级
     * @param level 游戏等级对象
     * @return 返回保存状态
     */
    public boolean saveLevel( LevelBean level);

    /**
     * 删除游戏等级
     * @param level 游戏等级对象
     * @return 返回删除状态
     */
    public boolean delLevel(LevelBean level);

    /**
     * 更新游戏等级信息
     * @param level 游戏等级对象
     * @return 返回更新的状态
     */
    public boolean updateLevel(LevelBean level);

    /**
     * 查询某个游戏的等级段位
     * @param gameName 游戏名
     * @return 返回查询的游戏等级段位集合
     */
    public List<LevelBean> selectLevelsByName(String gameName);
}
