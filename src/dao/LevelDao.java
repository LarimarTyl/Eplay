package dao;

import bean.LevelBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:20
 */
public interface LevelDao {
    public boolean saveLevel(String gameName, LevelBean level);
    public boolean delLevel(String gameName,LevelBean level);
    public boolean updateLevel(String gameName,LevelBean level);
    public List<LevelBean> selectLevelsByName(String gameName);//查询某个游戏的等级段位
}
