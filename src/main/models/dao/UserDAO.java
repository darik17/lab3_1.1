package models.dao;


import models.pojo.User;

/**
 * Created by admin on 23.04.2017.
 */
public interface UserDAO extends DAO<Integer, User> {
    User findUser (String login, String password);
}
