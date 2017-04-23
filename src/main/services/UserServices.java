package services;

import models.pojo.User;

/**
 * Created by admin on 22.04.2017.
 */
public interface UserServices {
    User auth(String login, String password);
}
