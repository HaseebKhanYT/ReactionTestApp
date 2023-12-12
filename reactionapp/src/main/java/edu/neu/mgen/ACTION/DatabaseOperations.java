package edu.neu.mgen.ACTION;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseOperations {
    public static void insertParticipant(String name, int age, String gender) {
        String sql = "INSERT INTO Participants (name, age, gender) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertGameResult(int participantId, int level, double averageTime, double accuracy) {
        String sql = "INSERT INTO GameResults (participant_id, level, average_time, accuracy) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, participantId);
            pstmt.setInt(2, level);
            pstmt.setDouble(3, averageTime);
            pstmt.setDouble(4, accuracy);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
