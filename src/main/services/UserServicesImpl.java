package main.services;


import main.models.dao.UserDAO;
import main.models.dao.UserDAOImpl;
import main.models.pojo.User;
import org.apache.log4j.Logger;

/**
 * Created by admin on 23.04.2017.qwe
 */
public class UserServicesImpl implements UserServices {

    private static final Logger LOGGER = Logger.getLogger(UserServicesImpl.class);

    private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public User auth(String login, String password) {

        User user = userDAO.findUser(login, password);
        LOGGER.debug("user: " + user);

        if(user == null ){
            LOGGER.error("Ошибка!");
            return null;
        } else
            return user;


    }
}
