package org.Cab_Booking_System.dao;
import org.Cab_Booking_System.model.User;
import org.Cab_Booking_System.utils.DBConnection;

import java.sql.*;

public class UserDAO {
    private Connection connection = DBConnection.getConnection();

    public boolean isUserExists(int userId, String email) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "SELECT 1 FROM users WHERE user_id = ? AND email = ?"
        );
        ps.setInt(1, userId);
        ps.setString(2, email);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public void register(User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO users (user_id, name, email, password, phone_number, licence_no, licence_exp) VALUES (?, ?, ?, ?, ?, ?, ?)"
        );

        ps.setInt(1, user.getUser_id());
        ps.setString(2, user.getName());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
        ps.setLong(5, user.getPhone_number());
        ps.setString(6, user.getLicence_no());
        ps.setString(7, user.getLicence_exp());

        ps.executeUpdate();
    }
    public boolean login(int userId, String password) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM users WHERE user_id = ? AND password = ?"
        );
        ps.setInt(1, userId);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public int updatePassword(int userId, String password) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "UPDATE users SET password = ? WHERE user_id = ?"
        );
        ps.setString(1, password);
        ps.setInt(2, userId);

        return ps.executeUpdate();
    }

    public int deleteUser(int userId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM users WHERE user_id = ?"
        );
        ps.setInt(1, userId);
        return ps.executeUpdate();
    }
}


