/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nidhro
 */
public class UserDao {

    String dbURL = "jdbc:postgresql://localhost:5432/postgres";
    String dbUser = "postgres";
    String dbPass = "1234";

    private String name, email, password, mobile;

    public UserDao(String name, String email, String password, String mobile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }

    public UserDao(String email, String password) {
        this.email = email;
        this.password = password;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserDao{" + "name=" + name + ", email=" + email + ", password=" + password + ", mobile=" + mobile + '}';
    }

    public void insertUser() {

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("DataBase Connected ");

            try {
                String query = "insert into users values(?,?,?,?)";
                Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
//                if (con != null) {
//                    System.out.println("Connection accomplished");
//                }
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, mobile);

                ps.executeUpdate();

                System.out.println("One record inserted...");
                ps.close();
                con.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public boolean check(String email, String password) {
        boolean res=false;
        String sql = "Select email, password from users where email=? and password=?";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
            Statement stmt = con.createStatement();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            res=rs.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

}
