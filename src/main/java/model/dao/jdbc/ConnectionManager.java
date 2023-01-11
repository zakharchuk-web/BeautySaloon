package model.dao.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import util.ResourcesUtil;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class that provides connection to database. Realised as a singleton.
 */
public class ConnectionManager {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionManager.class);

    private static final String JDBC_URL = "jdbc.url";
    private static final String JDBC_USER = "jdbc.user";
    private static final String JDBC_PASSWORD = "jdbc.password";

    private static ConnectionManager connectionManager;
    private DataSource dataSource;

    private ConnectionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/beauty_saloon", "root", "root");
        } catch (SQLException e) {
            LOGGER.warn("Can't create connection", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            throw new IllegalStateException("Connection manager hasn't initialized yet!");
        }
        return connectionManager;
    }

    /**
     * Method that creates connectionManager via JNDI
     *
     * @param name
     */
    public static void initFromJNDI(String name) {
        if (connectionManager != null) {
            return;
        }
        try {
            Context initialContext = new InitialContext();
            Context envContext = (Context) initialContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup(name);
            connectionManager = new ConnectionManager(ds);
        } catch (NamingException e) {
            LOGGER.error("Can't create initial context", e);
        }
    }

    /**
     * Method that creates connectionManager via data source like xxx.properties
     */
    public static void initFromProperties() {
        MysqlDataSource mysqlDs = new MysqlDataSource();

        Properties props = loadProperties();
        mysqlDs.setUrl(props.getProperty(JDBC_URL));
        mysqlDs.setUser(props.getProperty(JDBC_USER, "root"));
        mysqlDs.setPassword(props.getProperty(JDBC_PASSWORD, "root"));

        connectionManager = new ConnectionManager(mysqlDs);

    }

    /**
     * Method that uploads file with database credentials
     * @return
     */
    private static Properties loadProperties() {
        Properties properties = new Properties();

        File file = ResourcesUtil.getResourceFile("database.properties");

        try (InputStream inputStream = new FileInputStream(file)) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.warn("Cannot load database.properties", e);
        }

        return properties;
    }
}
