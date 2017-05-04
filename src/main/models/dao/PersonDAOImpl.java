package main.models.dao;


import main.models.ConnectionPool;
import main.models.pojo.Person;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 22.04.2017.q
 */


public class PersonDAOImpl implements PersonDAO {

    private static final Logger LOGGER = Logger.getLogger(PersonDAOImpl.class);

    private static final String SELECT_ALL = "SELECT person_id, fio, email, phone, " +
            " moderator  FROM person";
    private static final String INSERT_INTO = "INSERT INTO person (fio) VALUES(?)";
    private static final String UPDATE_WHERE = "UPDATE person SET fio  = ?, email = ?, phone = ?, moderator = ? WHERE person_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM person WHERE person_id=?";


    @Override
    public Collection<Person> getAll() {
        Set<Person> entities = new HashSet<>();

        try (Connection connection = ConnectionPool.getINSTANCE().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                entities.add(createEnity(resultSet));
            }

        } catch (SQLException e) {
            LOGGER.error("Проблема с выполнением запроса SELECT_ALL, к БД");
        }

        return entities;
    }

    @Override
    public Person getByID(Integer id) {
        Person person = null;
      /*  try (Connection connection = ConnectionPool.getINSTANCE().getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL + "WHERE public.person_id = ?")){
            statement.setInt(1, id);
            ResultSet resultSet =statement.executeQuery();
            if (resultSet.next()){
                person = createEnity(resultSet);
            }

        } catch (SQLException e){
           LOGGER.error("Проблема с выполнением запроса, к БД");
        }*/

        return person;
    }

    @Override
    public Integer insert(Person entity) {
        int result = -1;
      /*  try(Connection connection = ConnectionPool.getINSTANCE().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO, Statement.RETURN_GENERATED_KEYS)){

            statement.setString(1,entity.getFio());
            statement.setString(2,entity.getEmail());
            statement.setString(3,entity.getPhone());
            statement.setString(4,entity.getNickname());
            statement.setString(5,entity.getPassword());

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                result = resultSet.getInt(1);
            }

        }catch (SQLException e){
                LOGGER.error("Проблема с выполнением запроса, к БД");
        }*/
        return result;
    }

    @Override
    public void update(Person entity) {
        try (Connection connection = ConnectionPool.getINSTANCE().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_WHERE)) {

            statement.setString(1, entity.getFio());
            statement.setString(2, entity.getEmail());
            statement.setString(3, entity.getPhone());
            statement.setString(4, entity.getNickname());
            statement.setString(5, entity.getPassword());

            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Проблема с выполнением запроса UPDATE, к БД");
        }

    }

    @Override
    public void delete(Person entity) {
        try (Connection connection = ConnectionPool.getINSTANCE().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {

            statement.setInt(1, entity.getPerson_id());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Проблема с выполнением запроса DELETE, к БД");
        }
    }

    private Person createEnity(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setPerson_id(resultSet.getInt("person_id"));
        person.setFio(resultSet.getString("fio"));
        person.setEmail(resultSet.getString("email"));
        person.setPhone(resultSet.getString("phone"));
        person.setNickname(resultSet.getString("nickname"));
        person.setPassword(resultSet.getString("password"));
        person.setModerator(resultSet.getBoolean("moderator"));

        return person;


    }
}
