package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

    private final String URL = System.getenv("DB_URL");
    private final String USER = System.getenv("DB_USER");
    private final String PASSWORD = System.getenv("DB_PASSWORD");

    public Connection recuperarConexao() {
        try {
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}
