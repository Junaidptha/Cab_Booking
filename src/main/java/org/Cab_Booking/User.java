package org.Cab_Booking;

public class User {
    private int user_id;
    private String name;
    private String email;
    private String password;
    private long phone_number;
    private String licence_no;
    private String licence_exp;

    public User(int user_id, String name, String email, String password, long phone_number, String licence_no, String licence_exp) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.licence_no = licence_no;
        this.licence_exp = licence_exp;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getLicence_no() {
        return licence_no;
    }

    public void setLicence_no(String licence_no) {
        this.licence_no = licence_no;
    }

    public String getLicence_exp() {
        return licence_exp;
    }

    public void setLicence_exp(String licence_exp) {
        this.licence_exp = licence_exp;
    }
}
