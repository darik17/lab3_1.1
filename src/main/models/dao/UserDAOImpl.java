package models.dao;

import models.ConnectionPool;
import models.pojo.User;
import org.apache.log4j.Logger;
import services.UserServicesImpl;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by admin on 23.04.2017.
 */
public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserServicesImpl.class);

    @Override
    public Collection<User> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public User getByID(Integer id) {
        throw new NotImplementedException();
    }

    @Override
    public Integer insert(User entity) {
        throw new NotImplementedException();
    }

    @Override
    public void update(User entity) {
        throw new NotImplementedException();

    }

    @Override
    public void delete(User entity) {

        throw new NotImplementedException();
    }

    @Override
    public User findUser(String login, String password) {
        User user = null;

        try (Connection connection = ConnectionPool.getINSTANCE().getConnection();
             PreparedStatement statement = connection.prepareStatement
                     ("SELECT *FROM public.user WHERE login = ? AND password = ?")) {
            statement.setString(1, login); //"SELECT * FROM user WHERE login = ? AND password = ?"
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);
            }

            LOGGER.debug("user" + user);
        }catch (SQLException e){
                 LOGGER.error(e);

        }
        return user;
    }
    private User createEntity(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getInt("id"),
                resultSet.getString("login"),
                resultSet.getString("password"));
    }
}
