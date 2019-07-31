package servlet;

import service.AdminService;
import service.UserService;
import util.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr Wu
 * @create: 2019-07-31 14:40
 */
public class AdminServlet extends HttpServlet {

    private AdminService adminService;


    public AdminServlet(){
        adminService= Factory.getInstance("adminService",AdminService.class);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;char=utf-8");
        String servletPath = request.getServletPath();
        if(servletPath.contains("selectTop")){
            doSelectTopSpendUser(request,response);
            System.out.println("执行查询高消费用户的操作");
        }else if(servletPath.contains("newPlayer")){
            doNewPlayer(request,response);
            System.out.println("查询新秀主播的信息");
        }else if(servletPath.contains("checkPlayer")){
            doCheckPlayer(request,response);
            System.out.println("执行审核是否成为主播的操作");
        }else if(servletPath.contains("TopPricePlayers")){
            doSelectTopPricePlayers(request,response);
            System.out.println("执行查询高收入的主播");
        }else if(servletPath.contains("TopOrderPlayers")){
            doSelectTopOrderPlayers(request,response);
            System.out.println("执行查询高订单量的组播");
        }
    }

    /**
     *执行查询高消费的用户
     * */
    private void doSelectTopSpendUser(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行查询新秀主播的信息
     * */
    private void doNewPlayer(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行审核是否让申请用户成为主播
     * */
    private void doCheckPlayer(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     *执行查询高收入的主播的操作
     * */
    private void doSelectTopPricePlayers(HttpServletRequest request, HttpServletResponse response) {
    }
    /**
     * 执行查询高订单量主播的信息操作
     * */
    private void doSelectTopOrderPlayers(HttpServletRequest request, HttpServletResponse response) {
    }

}
