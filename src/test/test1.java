package test;

import bean.GameListBean;
import bean.LevelBean;
import bean.PlayerBean;
import dao.GameListDao;
import dao.impl.GameListDaoImpl;

import dao.impl.LevelDaoImpl;
import dao.impl.PlayerDaoImpl;

import dao.LevelDao;
import dao.PlayerDao;
import org.junit.Test;

import java.util.List;

/**
 * Create by mysteriousTime
 * time on 2019/7/25  11:02
 */
public class test1 {
   PlayerDao playerDao=new PlayerDaoImpl();
   LevelDao levelDao=new LevelDaoImpl();
   GameListDao gameListDao=new GameListDaoImpl();
   @Test
    public void savePlayer(){

       PlayerBean player=new PlayerBean(2,1,"阿球",1,"啊球","1","1","1","1",1,4,"1",1);
       playerDao.savePlayer(player);
   }
   @Test
   public void updatePlayer(){

      PlayerBean player=new PlayerBean("9",6,69,"9",0,2);
      playerDao.updatePlayer(player);
   }
   @Test
   public void delPlayer(){

      PlayerBean player=new PlayerBean(2);
      playerDao.delPlayer(player);
   }
   @Test
   public void selectAllPlayers(){

//      PlayerBean player=new PlayerBean(2);
      List<PlayerBean> list= playerDao.selectAllPlayers();
      System.out.println(list);
   }
   @Test
   public void pageAllPlayers(){

//      PlayerBean player=new PlayerBean(2);
      List<PlayerBean> list= playerDao.pageAllPlayers(1, 1);
      System.out.println(list);
   }
   @Test
   public void selectPlayersByStatus(){

      List<PlayerBean> list= playerDao.selectPlayersByStatus(0);
      System.out.println(list);

   }
   @Test
   public void saveLevel(){
      LevelBean level=new LevelBean(23,3,"荣耀王者");
      levelDao.saveLevel(level);
   }
   @Test
   public void delLevel(){
      LevelBean level=new LevelBean(18);
      levelDao.delLevel(level);
   }
   @Test
   public void updateLevel(){
      LevelBean level=new LevelBean(1,"弟弟",4);
      levelDao.updateLevel(level);
   }
   @Test
   public void selectLevelsByName(){
      List<LevelBean> list=levelDao.selectLevelsByName("王者荣耀");
      System.out.println(list);
   }
   @Test
   public void savaGamelist(){
      GameListBean gamelist =new GameListBean(6,"和平精英","打枪");
      gameListDao.saveGameList(gamelist);
      System.out.println("成功");
   }
   @Test
   public void delGamelist(){
      //GameListBean gamelist =new GameListBean(6,"和平精英","打枪");
      GameListBean gameListBean=new GameListBean(6);
      gameListDao.delGameList(gameListBean);
      System.out.println("成功");
   }
   @Test
   public void updateGamelist(){
      //GameListBean gamelist =new GameListBean(6,"和平精英","打枪");
      GameListBean gameListBean=new GameListBean("吃饭","睡觉",5);
      gameListDao.updateGameList(gameListBean);
      System.out.println("成功");
   }
   @Test
   public void selectAllGames() {
      List<GameListBean> listBeans;
     listBeans=gameListDao.selectAllGames();
      System.out.println(listBeans);
   }
   @Test
   public void selectAllGameByName() {
      GameListBean gameListBean=new GameListBean("吃饭");
      gameListDao.selectAllGameByName(gameListBean.getGameName());
   }
   @Test
   public void selectAllGameByid() {
      System.out.println(gameListDao.selectAllGameByid(1));

   }
}
