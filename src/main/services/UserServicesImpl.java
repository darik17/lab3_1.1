package main.services;


import main.models.dao.UserDAO;
import main.models.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 23.04.2017.qwe
 */
@Service
public class UserServicesImpl implements UserServices {

    private static final Logger LOGGER = Logger.getLogger(UserServicesImpl.class);

    private  UserDAO userDAO /*= new UserDAOImpl()*/;

    @Override
    public User auth(String login, String password) {

        User user = userDAO.findUser(login, password);
        LOGGER.debug("user: " + user);

        if (user == null) {
            LOGGER.error("Ошибка!");
            return null;
        } else
            return user;


    }

    @Override
    public User insert(String login, String password) {
        return null;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
