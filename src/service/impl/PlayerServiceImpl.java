package service.impl;

import bean.PlayerBean;
import dao.PlayerDao;
import service.PlayerService;
import util.Factory;

import java.util.List;

/**
 * @author Larimar
 * @time 2019/7/27 星期六 11:56
 */
public class PlayerServiceImpl implements PlayerService {
    PlayerDao playerDao = Factory.getInstance("playerDao",PlayerDao.class);

    @Override
    public List<PlayerBean> listAllPlayers() {
        return playerDao.selectAllPlayers();
    }

    @Override
    public List<PlayerBean> pageAllPlayers(int currentPage,int pageSize) {
        return playerDao.pageAllPlayers( currentPage, pageSize);
    }

    @Override
    public List<PlayerBean> listPlayersByStatus(int status) {
        return playerDao.selectPlayersByStatus(status);
    }

    @Override
    public List<PlayerBean> pagePlayersByStatus(int status,int currentPage,int pageSize) {
        return playerDao.pagePlayersByStatus(status, currentPage, pageSize);
    }

    @Override
    public List<PlayerBean> listPlayersByGameName(String name) {
        return playerDao.selectPlayersByGame(name);
    }

    @Override
    public List<PlayerBean> pagePlayersByGameName(String name,int currentPage,int pageSize) {
        return playerDao.pagePlayersByGame(name,currentPage,pageSize);
    }

    @Override
    public List<PlayerBean> listPlayersByGender(String gender) {
        return playerDao.selectPlayersByGame(gender);
    }

    @Override
    public List<PlayerBean> pagePlayersByGender(String gender,int currentPage,int pageSize) {
        return playerDao.pagePlayersByGender(gender, currentPage, pageSize);
    }

    @Override
    public List<PlayerBean> listPlayersByGameAndLevel(String name, String level) {
        return listPlayersByGameAndLevel(name,level);
    }

    @Override
    public List<PlayerBean> pagePlayersByGameAndLevel(String name, String level,int currentPage,int pageSize) {
        return pagePlayersByGameAndLevel(name, level, currentPage, pageSize);
    }

    @Override
    public List<PlayerBean> listPlayersByGameAndLevelAndGender(String name, String level, String gender) {
        return listPlayersByGameAndLevelAndGender(name, level, gender);
    }

    @Override
    public List<PlayerBean> pagePlayersByGameAndLevelAndGender(String name, String level, String gender,int currentPage,int pageSize) {
        return pagePlayersByGameAndLevelAndGender(name, level, gender, currentPage, pageSize);
    }

    @Override
    public PlayerBean getPlayerInfo(int playerId) {
        return playerDao.selectPlayById(playerId);
    }
}
