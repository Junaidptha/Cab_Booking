package org.Cab_Booking_System.Controller;

import org.Cab_Booking_System.model.User;
import org.Cab_Booking_System.service.UserService;

public class UserController {
    private final UserService userService = new UserService();

    public void registerUser(User user) {
        userService.register(user);
    }

    public boolean loginUser(int userId, String password) {
        return userService.login(userId, password);
    }

    public void updateUserPassword(int userId, String password) {
        userService.updatePassword(userId, password);
    }

    public void deleteUser(int userId) {
        userService.deleteUser(userId);
    }
}
