package org.Student;

import java.sql.*;

public class jbbd {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver"); // we can load class only
//            Class.forName("com.mysql.jdbc.Driver");
//            new org.postgresql.Driver();  // can load class and create object of this class
            System.out.println("cl");
            Connection cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "postgres","Khan@619");

//          Statement st = cn.createStatement(); // it support sql injection
//          st.executeUpdate("insert into emp values(11, 'amit')");
//
            PreparedStatement ps = cn.prepareStatement("Insert into emp values(?,?)"); // it doesn't support sql injection`
            ps.setInt(1, 101);
            ps.setString(2, "abc");
            ps.executeUpdate();


            PreparedStatement ps1= cn.prepareStatement("select * from emp");
            ResultSet rs = ps1.executeQuery();



            // create crud



            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
