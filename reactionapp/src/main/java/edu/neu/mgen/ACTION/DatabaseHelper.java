package edu.neu.mgen.ACTION;

import java.sql.*;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:test_results.db";

    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            // SQL statement for creating a new table
            String sql = "CREATE TABLE IF NOT EXISTS user_tests (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "name TEXT NOT NULL," +
                         "age INTEGER," +
                         "gender TEXT," +
                         "test_type INTEGER," +
                         "reaction_time DOUBLE," +
                         "accuracy DOUBLE" +
                         ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertTestData(String name, int age, String gender, int testType, double reactionTime, double accuracy) {
        String sql = "INSERT INTO user_tests(name, age, gender, test_type, reaction_time, accuracy) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setInt(4, testType);
            pstmt.setDouble(5, reactionTime);
            pstmt.setDouble(6, accuracy);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
