/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import techquizapp.dbutil.DBconnection;
import java.sql.SQLException;
import java.util.ArrayList;
import techquizapp.pojo.User;

public class UserDAO {
   public static boolean validateUser(User user) throws SQLException{
       Connection conn = DBconnection.getConnection();
       PreparedStatement pst = conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");
       pst.setString(1,user.getUserId());
       pst.setString(2, user.getPassword());
       pst.setString(3, user.getUserType());
       int res = pst.executeUpdate();
       return res==1;
   }
   public static boolean checkStudent(User user) throws SQLException{
       Connection conn = DBconnection.getConnection();
       PreparedStatement pst = conn.prepareStatement("select 1 from users where userid=? and usertype=?");
       pst.setString(1,user.getUserId());
       pst.setString(2, user.getUserType());
       ResultSet rs = pst.executeQuery();
       
       return rs.next();
   }
   public static boolean registerStudent(User user) throws SQLException{
       Connection conn = DBconnection.getConnection();
       PreparedStatement pst = conn.prepareStatement("insert into users values(?,?,?)");
       pst.setString(1,user.getUserId());
       pst.setString(2, user.getPassword());
       pst.setString(3, user.getUserType());
       int res = pst.executeUpdate();
       return res==1;
   }
   public static ArrayList<String> getAllStudentName()throws SQLException {
       Connection conn = DBconnection.getConnection();
       PreparedStatement pst = conn.prepareStatement("select userid from users where usertype='student'");
       ResultSet rs =  pst.executeQuery();
       ArrayList<String> userid = new ArrayList<>();
       while(rs.next()){
           userid.add(rs.getString(1));
       }
       return userid;
    }
    public static boolean changePassword(User user) throws SQLException{
       Connection conn = DBconnection.getConnection();
       PreparedStatement pst = conn.prepareStatement("update users set password = ? where userid=? and usertype=?");
       pst.setString(2,user.getUserId());
       pst.setString(1, user.getPassword());
       pst.setString(3, user.getUserType());
       int res = pst.executeUpdate();
       return res==1;
   } 
       
}
