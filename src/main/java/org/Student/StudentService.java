package org.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentService {
    Connection con;
    Statement st;
    ResultSet rs;
    Student std;
    String status ="";
    public StudentService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my1", "root", "root");
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String add(String sid, String sname, String saddr) {
        try {
            rs = st.executeQuery("select * from student where sid='"+sid+"'");
            boolean b = rs.next();
            if(b == true) {
                status = "existed";
            }else {
                st.executeUpdate("insert into student values('"+sid+"','"+sname+"','"+saddr+"')");
                status = "success";
            }
        } catch (Exception e) {
            status = "failure";
            e.printStackTrace();
        }
        return status;
    }
    public Student search(String sid) {
        try {
            rs = st.executeQuery("select * from student where sid='"+sid+"'");
            boolean b = rs.next();
            if(b == true) {
                std = new Student();
                std.setSid(rs.getString("SID"));
                std.setSname(rs.getString("SNAME"));
                std.setSaddr(rs.getString("SADDR"));
            }else {
                std = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return std;
    }
    public String update(String sid, String sname, String saddr) {
        try {
            st.executeUpdate("update student set sname='"+sname+"',saddr='"+saddr+"' where sid='"+sid+"'");
            status = "success";
        } catch (Exception e) {
            status = "failure";
            e.printStackTrace();
        }
        return status;
    }
    public String delete(String sid) {
        try {
            rs = st.executeQuery("select * from student where sid='"+sid+"'");
            boolean b = rs.next();
            if(b == true) {
                st.executeUpdate("delete from student where sid='"+sid+"'");
                status = "success";
            }else {
                status = "notexisted";
            }
        } catch (Exception e) {
            status = "failure";
            e.printStackTrace();
        }
        return status;
    }

}
