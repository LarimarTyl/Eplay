package dao;

import bean.PlayerBean;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 16:21
 */
public interface PlayerDao {
    /**
     * 保存用户信息
     * @param player
     * @return 保存玩家的状态
     */
    public boolean savePlayer(PlayerBean player);
    /**
     * 删除用户信息
     * @param player
     * @return 删除用户的状态
     */
    public boolean delPlayer(PlayerBean player);
    /**
     * 跟新用户信息
     * @param player
     * @return 更新用户的状态
     */
    public boolean updatePlayer(PlayerBean player);

    /**
     * 查看所有的玩家信息
     * @return 所有的玩家信息集合
     */
    public List<PlayerBean> selectAllPlayers();

    /**
     * 分页查看所有的玩家信息
     * @param currentPage
     * @param pageSize
     * @return 分页查看所有的玩家的集合
     */
    public List<PlayerBean> pageAllPlayers(int currentPage,int pageSize);

    /**
     * 根据玩家状态查找玩家
     * @param status 状态 （0可接单，1待接单（下单未回复），2已经接单）
     * @return 给定状态的玩家集合
     */
    public List<PlayerBean> selectPlayersByStatus(int status);

    /**
     * 根据玩家状态分页查找玩家（
     * @param status 状态 0可接单，1待接单（下单未回复），2已经接单）
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 分页后该状态的玩家集合
     */
    public List<PlayerBean> pagePlayersByStatus(int status,int currentPage,int pageSize);

    /**
     * 根据不同的价格查找玩家
     * @param price 价格
     * @return 根据不同的价格查找玩家
     */
    public List<PlayerBean> selectPlayersByPrice(double price);

    /**
     * 根据不同的价格分页查找玩家
     * @param price 价格
     * @param currentPage 当前页面
     * @param pageSize 页面大小
     * @return 分页当前价格区间的玩家集合
     */
    public List<PlayerBean> pagePlayersByPrice(double price,int currentPage,int pageSize);

    /**
     * 根据游戏名字查找玩家
     * @param gameName 游戏名字
     * @return 特定游戏名的玩家
     */
    public List<PlayerBean> selectPlayersByGame(String gameName);

    /**
     * 根据游戏名字分页查找玩家
     * @param gameName 游戏名
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 分页特定游戏名的玩家集合
     */
    public List<PlayerBean> pagePlayersByGame(String gameName,int currentPage,int pageSize);

    /**
     * 根据性别查找玩家
     * @param gender 性别
     * @return 返回指定性别的玩家
     */
    public List<PlayerBean> selectPlayersByGender(String gender);

    /**
     * 根据性别分页查找玩家
     * @param gender 性别
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 分页特定性别的玩家
     */
    public List<PlayerBean> pagePlayersByGender(String gender,int currentPage,int pageSize);

    /**
     * 根据游戏名和段位等级查找玩家
     * @param gameName 游戏名
     * @param level 段位等级
     * @return 特定游戏和特定等级的玩家集合
     */
    public List<PlayerBean> selectPlayersByGameAndLevel(String gameName,String level);

    /**
     * 根据游戏名和段位等级分页查找玩家
     * @param gameName 游戏名
     * @param level 游戏段位等级
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 分页特定段位特定游戏名的玩家
     */
    public List<PlayerBean> pagePlayersByGameAndLevel(String gameName,String level,int currentPage,int pageSize);

    /**
     * 根据游戏名、段位、性别查找玩家
     * @param gameName 游戏名
     * @param level 段位等级
     * @param gender 性别
     * @return 符合条件的玩家列表
     */
    public List<PlayerBean> selectPlayersByGameAndLevelAndGender(String gameName,String level,String gender);

    /**
     * 根据游戏名、段位、性别分页查找玩家
     * @param gameName 游戏名
     * @param level 段位等级
     * @param gender 性别
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 分页后的数据
     */
    public List<PlayerBean> pagePlayersByGameAndLevelAndGender(String gameName,String level,String gender,int currentPage,int pageSize);

    /**
     * 根据玩家名字查找玩家
     * @param playerName 玩家名
     * @return 返回对应名字的玩家
     */
    public PlayerBean selectPlayByName(String playerName);

    /**
     * 根据玩家id查找玩家
     * @param playerId
     * @return 返回对应id的玩家
     */
    public PlayerBean selectPlayById(int playerId);

    /**
     * 查找最新入驻的玩家
     * @return 最新入驻的玩家
     */
    public List<PlayerBean> selectNewPlayers();

    /**
     * 根据玩家编号查找玩家状态
     * @param id 玩家id playerID
     * @return 返回该id的玩家状态
     */
    public int selectPlayerStatus(int id);
    public List<PlayerBean> selectPlayersByPlayerId(int id);
}
