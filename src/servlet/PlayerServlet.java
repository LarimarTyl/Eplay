package servlet;

import bean.PlayerBean;
import dao.PlayerDao;
import service.PlayerService;
import util.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-07-31 14:40
 */
@WebServlet("*.player")
public class PlayerServlet extends HttpServlet {
    PlayerService playerService;
    PlayerDao playerDao;

    public PlayerServlet() {
        playerService = Factory.getInstance("playerService",PlayerService.class);
        playerDao = Factory.getInstance("playerDao",PlayerDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;char=utf-8");
        String servletPath = request.getServletPath();
        if (servletPath.contains("listBySex")){
            System.out.println("根据性别检索玩家");
            doListBySex(request,response);
        }if (servletPath.contains("listByGame")) {
            System.out.println("根据游戏检索玩家");
            doListByGame(request,response);
        } if (servletPath.contains("listByGameLevel")) {
            System.out.println("根据游戏等级检索玩家");
            doListByGameLevel(request,response);
        }if (servletPath.contains("listByGameLevelSex")){
            System.out.println("根据游戏性别等级检索玩家 ");
            doListByGameLevelSex(request,response);
        }if (servletPath.contains("showPlayerInfo")){
            System.out.println("展示玩家信息");
            doshowPlayerInfo(request,response);
        }
    }

    private void doshowPlayerInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int playerId = Integer.valueOf(request.getParameter("playerID"));
        String playerName = request.getParameter("playerName");
        PlayerBean playerInfo = playerDao.selectPlayByName(playerName);
        List<PlayerBean> playerGameInfo = playerDao.selectPlayersByPlayerId(playerId);
        if (playerInfo!=null){
            System.out.println("输出玩家信息");
            System.out.println(playerInfo);
            request.getSession().setAttribute("playerInfo",playerInfo);
        }if (playerGameInfo!=null){
            System.out.println("输出玩家游戏信息");
            System.out.println(playerGameInfo);
            request.getSession().setAttribute("playerGameInfo",playerGameInfo);
        }
        request.getRequestDispatcher("/public/html/index/playerInfo.jsp").forward(request,response);
    }

    private void doListByGameLevelSex(HttpServletRequest request, HttpServletResponse response) {

    }

    private void doListByGameLevel(HttpServletRequest request, HttpServletResponse response) {

    }

    private void doListByGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gameName = request.getParameter("gameName");
        List<PlayerBean> playerBeans;
        if (gameName.equals("全部玩家")){
            playerBeans = playerService.listAllPlayers();
        }else {
            playerBeans = playerService.listPlayersByGameName(gameName);
        }
        if (playerBeans.size()>0){
            System.out.println(playerBeans);
            request.getSession().setAttribute("players",playerBeans);
            request.getRequestDispatcher("/public/html/index/list.jsp").forward(request,response);
        }

    }

    private void doListBySex(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
