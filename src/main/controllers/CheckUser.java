package controllers;

import org.apache.log4j.Logger;
import services.UserServices;
import services.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by admin on 23.04.2017.
 */
public class CheckUser extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(CheckUser.class);

    private static UserServices userServices = new UserServicesImpl();

  /*  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Enumeration val =req.getParameterNames();
//        String n = (String)val.nextElement();
        String login = req.getParameter("user");
        String passw = req.getParameter("password");
       // String login = req.getParameter("user");
       // String passw = req.getParameter("password");

        LOGGER.info("Значения:");
        LOGGER.info(login);
        LOGGER.info(passw);
        //LOGGER.info(loginN);
        if (userServices.auth(login, passw) != null) {
            req.getSession().setAttribute("userLogin", login);
            LOGGER.debug("user : " + login + "logged");
            resp.sendRedirect(req.getContextPath() + "/userpages.jsp");

        }
        else {
            LOGGER.error("NO DATA!");
            resp.sendRedirect(req.getContextPath()+ "/registration.jsp");

        }
    }
*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String login = req.getRequestDispatcher("user").toString();
//        String passw = req.getRequestDispatcher("password").toString();
//        String login = req.getParameterValues("user")[0];
//        String passw = req.getParameterValues("password")[1];
        String login = req.getParameter("user");
        String passw = req.getParameter("password");
        LOGGER.info(login);
        LOGGER.info(passw);

        if (userServices.auth(login, passw) != null) {
            req.getSession().setAttribute("userLogin", login);
            LOGGER.debug("user : " + login + " logged");
            resp.sendRedirect(req.getContextPath() + "/userpages.jsp");

        }
        else {
            LOGGER.error("NO DATA!");
            resp.sendRedirect(req.getContextPath()+ "/registration.jsp");

        }

    }
}
