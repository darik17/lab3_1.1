package main.models;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by admin on 22.04.2017.1
 */
public class ConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final ConnectionPool INSTANCE = new ConnectionPool();

    private BoneCP boneCP;

    public static ConnectionPool getINSTANCE() {
        return INSTANCE;
    }

    private ConnectionPool() {
        Properties dbProperties = new Properties();

        try (InputStream is = ConnectionPool.class.getClassLoader()
                .getResourceAsStream("database.properties")) {
            dbProperties.load(is);
            Class.forName("org.postgresql.Driver");

            BoneCPConfig config = new BoneCPConfig();
            config.setJdbcUrl(dbProperties.getProperty("url"));
            config.setUsername(dbProperties.getProperty("user"));
            config.setPassword(dbProperties.getProperty("password"));
            config.setMinConnectionsPerPartition(5);
            config.setMaxConnectionsPerPartition(10);
            config.setPartitionCount(1);
            boneCP = new BoneCP(config);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            LOGGER.error("Проблема с созданием к БД");
        }
    }

    public Connection getConnection() throws SQLException {
        return boneCP.getConnection();
    }
}
