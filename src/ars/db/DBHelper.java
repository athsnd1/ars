/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ars.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DBHelper {
    
    private static final String url = "jdbc:postgresql://localhost:5432/flightsdb";
    private static final String username = System.getenv("DB_USER");
    private static final String password = System.getenv("DB_PASS");
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }
}
