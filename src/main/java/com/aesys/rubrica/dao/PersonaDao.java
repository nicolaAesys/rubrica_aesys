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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Aesys
 */
public class PersonaDao {
    
    
    public List<Persona> getListapersone() throws SQLException, ClassNotFoundException{
        
        
     List<Persona> persone = new ArrayList<>();
     
    
        String query="SELECT * FROM persone";
         Connection conn = ConnessioneDao.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
       
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
           persone.add(new Persona(rs.getString("nome"), rs.getString("cognome"), rs.getString("numero")));
    
        }
    return persone;
    }
    
    public boolean insert(Persona persona) throws ClassNotFoundException, SQLException{
        
       // String query="SELECT * FROM persone";
         Connection conn = ConnessioneDao.getConnection();
         
        Statement stmt=conn.createStatement();
        

    stmt.execute("INSERT INTO persone VALUES ('" + persona.getNome()+ "', '" + persona.getCognome() +"', " +persona.getTelefono()+ ")");
 
    stmt.close();

    conn.close();
        
       // RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
         //   dispatcher.forward(request, response);
    return true;
    }
    
}
