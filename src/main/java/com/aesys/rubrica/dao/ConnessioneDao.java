/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aesys.rubrica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Aesys
 */
public class ConnessioneDao {
    
     public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties propr = new Properties();
<<<<<<< HEAD

=======
        /* dati */
>>>>>>> 161eeb0b552a5df9cc8b80762d78c786b5aaf9b4
        Connection conn = DriverManager.getConnection(url, propr);
        return conn;
    }
    
}
