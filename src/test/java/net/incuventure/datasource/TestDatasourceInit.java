package net.incuventure.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.jdbc.SqlRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDatasourceInit {

    @Test
    public void testPoolCreation() throws SQLException {

        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(100);

        config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        config.addDataSourceProperty("serverName", "localhost");
        config.addDataSourceProperty("port", "3306");
        config.addDataSourceProperty("databaseName", "employees");
        config.addDataSourceProperty("user", "test");
        config.addDataSourceProperty("password", "test");

        HikariDataSource ds = new HikariDataSource(config);
        ds.setConnectionTimeout(1000);

        try {
            try (Connection connection = ds.getConnection()) {
                // use the connection

                String sql = "select * from employees where gender = ?";

                PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet resultSet = pstmt.executeQuery();

//                Map params = new HashMap<>();
//                params.put("gender", "M");
//
//                SqlRunner sqlRunner = new SqlRunner(connection);
//
//                List results = sqlRunner.selectAll(sql, "M");

                System.out.printf("zz");

            }
        } catch(SQLException sqle) {
            throw(sqle);
        }

    }

}
