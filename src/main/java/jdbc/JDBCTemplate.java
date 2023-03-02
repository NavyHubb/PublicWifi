package jdbc;

import java.sql.*;

public class JDBCTemplate {
    public static Connection getConnection() {

        String url = "jdbc:mariadb://172.30.1.23:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static boolean isConnection(Connection connection) {
        boolean valid = true;

        try {
            if (connection == null || connection.isClosed()) {
                valid = false;
            }
        } catch (SQLException e) {
            valid = true;
            e.printStackTrace();
        }

        return valid;
    }

    public static void close(Connection connection) {
        if (isConnection(connection)) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // rs가 null이 아닐 때 close
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 연결 상태라면 commit
    public static void commit(Connection connection) {
        if (isConnection(connection)) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 연결 상태라면 rollback
    public static void rollback(Connection connection) {
        if (isConnection(connection)) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
