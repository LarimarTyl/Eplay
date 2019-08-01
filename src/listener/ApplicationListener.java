package listener; /**
 * @author Larimar
 * @time 2019/8/2 周五 2:51
 */

import bean.PlayerBean;
import service.AdminService;
import service.PlayerService;
import util.Factory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.List;

@WebListener()
public class ApplicationListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    private PlayerService playerService;
    private AdminService adminService;

    // Public constructor is required by servlet spec
    public ApplicationListener() {
        playerService = Factory.getInstance("playerService", PlayerService.class);
        adminService = Factory.getInstance("adminService", AdminService.class);
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        List<PlayerBean> playerBeans = playerService.listAllPlayers();
        List<PlayerBean> newPlayer = adminService.listNewPlayers();
        ServletContext application = sce.getServletContext();
        if (playerBeans != null && newPlayer != null) {
            application.setAttribute("playerBeans", playerBeans);
            application.setAttribute("newPlayer", newPlayer);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
