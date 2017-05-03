package main.controllers;

import main.services.PersonServices;
import main.services.PersonServicesImpl;
import main.services.UserServices;
import main.services.UserServicesImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 03.05.2017. 123
 */

    public class RegistrationServlet extends HttpServlet {

        private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);
        private static PersonServices personServices  = new PersonServicesImpl();
        private static UserServices userService = new UserServicesImpl();
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/registration.jsp")
                    .forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String user = req.getParameter("user");
            String password = req.getParameter("password");
            String fio = req.getParameter("fio");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");

            LOGGER.debug("user " + user + fio);

            if(user=="" && password=="" && fio=="" &&
                    email=="" && phone=="") {
                resp.sendRedirect(req.getContextPath() + "/Registration");
            }else{
                userService.insert(user,password);
                personServices.insert(fio,email,phone);
                resp.sendRedirect(req.getContextPath() + "/");
            }

        }
    }



