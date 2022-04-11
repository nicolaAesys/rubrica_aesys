/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.aesys.rubrica.Login;

import com.aesys.rubrica.dao.PersonaDao;
import com.mycompany.modello.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.vm.ci.code.Register;


/**
 *
 * @author Aesys
 */
public class UpdateContactServlet extends HttpServlet {   @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String nome = request.getParameter("nameUpdate");
        String cognome = request.getParameter("surnameUpdate");
        String telefono = request.getParameter("phoneUpdate");
        
        List<String> errorLog = (List<String>) session.getAttribute("errors");
        
        Persona contactUpdated = new Persona(nome, cognome, telefono);
        
        try {
            PersonaDao.updateContact(username, nome, cognome, telefono);
            session.setAttribute(
                    "contactUpdated",
                    contactUpdated.toString()
                    + " Succesfully Updated!");
            session.setAttribute("contactList", PersonaDao.getContactList(username));
            response.sendRedirect ("update.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }    response.sendRedirect ("update.jsp");
    }

      
        }
        
