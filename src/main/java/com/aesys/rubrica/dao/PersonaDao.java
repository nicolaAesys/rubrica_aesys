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
    
    
    
    
    public static List<Persona> getListapersone() throws SQLException, ClassNotFoundException{
        
        
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
    
    public static void updateContact(String user_proprietary, String name, String surname, String phoneNew) throws SQLException, ClassNotFoundException{
        System.out.println("Enter");
        Connection con = ConnessioneDao.getConnection();
        String query = "UPDATE contacts SET phone="+phoneNew+" WHERE name=? AND surname=? AND user_proprietary=?";
        PreparedStatement stat = con.prepareStatement(query);
        stat.setString(1, name);
        stat.setString(2, surname);
        stat.setString(3, user_proprietary);
        
        stat.executeUpdate();
        System.out.println("Success");
    }
    
    public boolean insert(Persona persona) throws ClassNotFoundException, SQLException{
        
       // String query="SELECT * FROM persone";
         Connection conn = ConnessioneDao.getConnection();
         
        PreparedStatement stmt=conn.prepareStatement("INSERT INTO persone VALUES (?,?,?)");
        

            stmt.execute();
            stmt.setString(1,persona.getNome());
            stmt.setString(2, persona.getCognome());
            stmt.setString(3, persona.getTelefono());
            stmt.close();

            conn.close();
        
       // RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
         //   dispatcher.forward(request, response);
    return true;
    }
    
    public boolean delete(Persona persona) throws ClassNotFoundException, SQLException{
        
         Connection conn = ConnessioneDao.getConnection();
         
        Statement stmt=conn.createStatement();
            
            stmt.execute("DELETE FROM persone WHERE name = "+ persona.getNome()+ ";");
            
            stmt.close();
        
        return true;
    }
    
    public static ArrayList<Persona> getContactList(String username) throws ClassNotFoundException, SQLException{
        
        ArrayList<Persona> contactList = new ArrayList<>();
        
      Connection con = ConnessioneDao.getConnection();
        
        String query = "SELECT * FROM contacts WHERE user_proprietary=?";
        PreparedStatement stat = con.prepareStatement(query);
        
        stat.setString(1, username);
        ResultSet res = stat.executeQuery();
        
        while(res.next()){
            String name = res.getString("name");
            String surname = res.getString("surname");
            String phone = res.getString("phone");
            
            contactList.add(new Persona(name, surname, phone));
        }
        
        return contactList;
    }
    
    
}
