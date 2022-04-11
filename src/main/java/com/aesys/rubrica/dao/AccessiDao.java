/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aesys.rubrica.dao;

import com.mycompany.modello.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aesys
 */
public class AccessiDao {
    
    
    public boolean verificaAccesso(String user, String Password) throws ClassNotFoundException, SQLException{
        Connection conn = ConnessioneDao.getConnection();
        String query="select * from accessi where username=? and password=? and attivo=true";
        
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,user);
        ps.setString(2,Password);
        
        ResultSet rs = ps.executeQuery();
        
       
    return rs.next();
    }
    
}
