/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ProdutoDAO;

import entidade.Produto;
import java.io.IOException;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tscarton
 */
public class listaProduto extends HttpServlet {

    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Produto> listaProdutos = null;
         try {
             listaProdutos = ProdutoDAO.getProdutos();
         } catch (SQLException ex) {
             Logger.getLogger(listaProduto.class.getName()).log(Level.SEVERE, null, ex);
         }
        request.setAttribute("listaProdutos", listaProdutos);
        
         RequestDispatcher requestDispatcher = getServletContext()
                 .getRequestDispatcher("/listaProdutos.jsp");
         requestDispatcher.forward(request, response);
    }

   


}

