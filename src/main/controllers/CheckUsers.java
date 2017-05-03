package main.controllers;

import main.models.pojo.User;
import main.services.UserServices;
import main.services.UserServicesImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 23.04.2017.111
 */
public class CheckUsers extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(CheckUsers.class);

    private static UserServices userServices = new UserServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("user");
        String passw = req.getParameter("password");
        LOGGER.info(login);
        LOGGER.info(passw);

        User user = userServices.auth(login,passw);

        if (user != null) {
            req.getSession().setAttribute("userLogin", login);
            req.getSession().setAttribute("userId",user);

            LOGGER.debug("user : " + login + " logged");
            resp.sendRedirect(req.getContextPath() + "/userpages.jsp");

        } else {
            LOGGER.error("Ошибка входа!");
            resp.sendRedirect(req.getContextPath() + "/");

        }

    }

   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("user");
        String passw = req.getParameter("password");
        LOGGER.info(login);
        LOGGER.info(passw);

        if (userServices.auth(login, passw) != null) {
            req.getSession().setAttribute("userLogin", login);
            LOGGER.debug("user : " + login + " logged");
            resp.sendRedirect(req.getContextPath() + "/userpages.jsp");

        } else {
            LOGGER.error("NO DATA!");
            resp.sendRedirect(req.getContextPath() + "/registration.jsp");

        }
    }*/
}
