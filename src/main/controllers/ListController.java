package main.controllers;

import main.models.pojo.Person;
import main.services.PersonServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 03.05.2017. 123
 */
public class ListController extends HttpServlet {
    public  static PersonServicesImpl service = new PersonServicesImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("value", "Hello, ");

        List<Person> usersInformations = service.getAllPerson();
        req.setAttribute("usersInformations", usersInformations);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listUsers.jsp");
        dispatcher.forward(req, resp);
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
