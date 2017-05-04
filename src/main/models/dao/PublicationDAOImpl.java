package main.models.dao;


import main.models.ConnectionPool;
import main.models.pojo.Publication;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 22.04.2017.qas
 */
public class PublicationDAOImpl implements PublicationDAO {

    private static final Logger LOGGER = Logger.getLogger(PublicationDAOImpl.class);

    private static final String SELECT_ALL = "SELECT publicaton_id, name_publication, tag, text_publicaton, comment" +
            "moder, person_id FROM public.publication";
    private static final String INSERT_INTO = "INSERT INTO person (fio) VALUES(?)";
    private static final String UPDATE_WHERE = "UPDATE person SET fio  = ?, email = ?, phone = ?, moderator = ? WHERE person_id = ? ";
    private static final String DELETE_BY_ID = "DELETE FROM person WHERE person_id=?";


    @Override
    public Collection<Publication> getAll() {
        Set<Publication> entities = new HashSet<>();
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
    public Publication getByID(Integer id) {
        return null;
    }

    @Override
    public Integer insert(Publication entity) {
        return null;
    }

    @Override
    public void update(Publication entity) {

    }

    @Override
    public void delete(Publication entity) {

    }

    private Publication createEnity(ResultSet resultSet) throws SQLException {
        Publication publication = new Publication();
        publication.setPublication_id(resultSet.getInt("publicaton_id"));
        publication.setName_publication(resultSet.getString("name_publication"));
        publication.setTag(resultSet.getString("tag"));
        publication.setText_publication(resultSet.getString("text_publicaton"));
        publication.setModer(resultSet.getBoolean("moder"));
        publication.setComment(resultSet.getString("comment"));
        publication.setPerson_id(resultSet.getInt("person_id"));

        return publication;
    }
}
