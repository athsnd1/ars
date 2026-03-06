/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ars.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class UsersDAO {
    public static boolean registerUser(String username, String password, String role){
        String sql = "INSERT INTO users(username,password,role) VALUES(?,?,?)";
        try(Connection conn = DBHelper.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
                ){stmt.setString(1,username);
                stmt.setString(2,password);
                stmt.setString(3,role);
                int rowsInserted = stmt.executeUpdate();
                return rowsInserted>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean validateLogin(String username,String password){
        
        boolean isValid = false;
        
        try(Connection conn = DBHelper.getConnection();){
            String sql = "SELECT password FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String dbPassword = rs.getString("password");
                if(password.equals(dbPassword)){
                    isValid = true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
          
        }catch(SQLException e){
            e.printStackTrace();
          
            
        }
        return isValid;
    }
    
    public String getRole(String username) throws SQLException{
        String sql = "SELECT role FROM users WHERE username = ?";
        try{
            Connection conn = DBHelper.getConnection();
            PreparedStatement pst;
            pst = conn.prepareStatement(sql);
            pst.setString(1,username);
            ResultSet rs = pst.executeQuery(); 
            
            if(rs.next()){
                return rs.getString("role");
            }
            }
    catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
        }
    
    public static boolean deleteUser(int id)throws SQLException{
        String sql = "DELETE FROM users WHERE id = ?";
        try(Connection conn = DBHelper.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            int affected = stmt.executeUpdate();
            return affected > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
}
