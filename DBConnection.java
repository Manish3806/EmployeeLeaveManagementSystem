package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            String url = "jdbc:mysql://localhost:3306/employee_leave_db";
            String user = "root";
            String password = "12345678";

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
