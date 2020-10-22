/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ProdutoDAO;
import utils.Utils;
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
 * @author tscarton
 */
public class ExcluirProduto extends HttpServlet {

    

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod_produto = Integer.parseInt(request.getParameter("cod_produto"));
       try {
           ProdutoDAO.deletaProduto(cod_produto);
           response.getWriter().print(true);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(ExcluirProduto.class.getName()).log(Level.SEVERE, null, ex);
           response.getWriter().print(false);
       } 
        
    }


}
