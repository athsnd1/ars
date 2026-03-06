/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ars.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class FlightsDAO {
    public boolean addFlight(String origin, String destination, String departure_time, String arrival_time, String status) throws SQLException{
        String sql = "INSERT INTO flights(origin,destination,departure_time,arrival_time,status) VALUES(?,?,?,?,?)";
        try(Connection conn = DBHelper.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,origin);
            stmt.setString(2,destination);
            stmt.setString(3,departure_time);
            stmt.setString(4,arrival_time);
            stmt.setString(5,status);
            int rows = stmt.executeUpdate();
            return rows > 0;       
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

public static boolean deleteFlight(int id)throws SQLException{
        String sql = "DELETE FROM flights WHERE id = ?";
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

public boolean updateFlight(int id, String origin, String destination,String departure_time,String arrival_time,String status)throws SQLException{
    String sql = "UPDATE flights SET origin=?,destination=?,departure_time=?,arrival_time=?,status=? WHERE id=?";
    try(Connection conn  = DBHelper.getConnection();
        PreparedStatement pst =  conn.prepareStatement(sql)){
        pst.setString(1,origin);
        pst.setString(2,destination);
        pst.setString(3,departure_time);
        pst.setString(4,arrival_time);
        pst.setString(5,status);
        pst.setInt(6,id);
        int rows = pst.executeUpdate();
        if(rows >1){
            return true; 
        }
       
    }catch(SQLException ex){
        ex.printStackTrace();
    }
    return false;
}
}
