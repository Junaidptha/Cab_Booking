package org.Cab_Booking;

public class User {
    private int user_id;
    private String userEmail;
    private String password;

    public User(String userEmail, int user_id, String password) {
        this.userEmail = userEmail;
        this.user_id = user_id;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
