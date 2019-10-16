package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
	
	static String driver = "jdbc:oracle:thin:@localhost:1521:XE";
	static String databaseName = "SPRINGDATABASE";
	static String password = "123";

	public static void main(String[] args) {
		
	
        try (Connection conn = DriverManager.getConnection(
        		driver, databaseName, password)) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
		
}
