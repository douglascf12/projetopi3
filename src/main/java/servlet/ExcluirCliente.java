/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */
public class ExcluirCliente extends HttpServlet {

   
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cpf_cliente = request.getParameter("cpf_cliente");
       try {
           ClienteDAO.deleteCliente(cpf_cliente);
           response.getWriter().print(true);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(ExcluirCliente.class.getName()).log(Level.SEVERE, null, ex);
           response.getWriter().print(false);
       } 
        
    }
        
  }
