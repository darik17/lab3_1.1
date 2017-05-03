package main.models.dao;


import main.models.pojo.User;

/**
 * Created by admin on 23.04.2017. 123
 */
public interface UserDAO extends DAO<Integer, User> {
    User findUser(String login, String password);
}
