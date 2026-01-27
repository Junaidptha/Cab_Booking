package org.Student;

import java.sql.*;
import java.util.Scanner;
public class LoginPage {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "postgres","Khan@619");
            //Statement st=cn.createStatement();
            Scanner s=new Scanner(System.in);
            System.out.println("pls enter the password");
            String a=s.nextLine();
            System.out.println("pls enter the userid");
            String b=s.nextLine();

            PreparedStatement ps=cn.prepareStatement("select * from user where upassword=? and userid=?");
            ps.setString(1, a);
            ps.setString(2, b);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                System.out.println("login");
            }else {
                System.out.println("invalid id or password");
            }
            cn.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


