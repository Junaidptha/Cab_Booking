package org.Cab_Booking_System.service;

import org.Cab_Booking_System.dao.UserDAO;
import org.Cab_Booking_System.model.User;

public class UserService {
    private final UserDAO userDao = new UserDAO();

    public void register(User user) {
        try {
            if (userDao.isUserExists(user.getUser_id(), user.getEmail())) {
                System.out.println("User already exists");
                return;
            }
            userDao.register(user);
            System.out.println("User registered successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(int userId, String password) {
        try {
            boolean success = userDao.login(userId, password);
            if (success) {
                System.out.println("Login successful");
            } else {
                System.out.println("Invalid credentials");
            }
            return success;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePassword(int userId, String password) {
        try {
            int row = userDao.updatePassword(userId, password);
            System.out.println(row > 0 ? "User updated" : "User not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int userId) {
        try {
            int row = userDao.deleteUser(userId);
            System.out.println(row > 0 ? "User deleted" : "User not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
