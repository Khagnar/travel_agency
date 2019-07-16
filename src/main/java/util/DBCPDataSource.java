package util;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDataSource {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Travel agency";
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_NAME = "postgres";
    private static final String DB_PASS = "1234";

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl(DB_URL);
        ds.setUsername(DB_NAME);
        ds.setPassword(DB_PASS);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(20);
    }

    private DBCPDataSource(){
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
