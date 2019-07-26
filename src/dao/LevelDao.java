package dao;

import bean.LevelBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:20
 */
public interface LevelDao {
    public boolean saveLevel( LevelBean level);
    public boolean delLevel(LevelBean level);
    public boolean updateLevel(LevelBean level);
    public List<LevelBean> selectLevelsByName(String gameName);//查询某个游戏的等级段位
}
