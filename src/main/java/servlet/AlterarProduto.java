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
public class AlterarProduto extends HttpServlet {

  
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod_produto = Integer.parseInt(request.getParameter("cod_produto"));
        Produto produto = ProdutoDAO.getProduto(cod_produto);
        request.setAttribute("produto", produto);
         RequestDispatcher rd = 
                 getServletContext().getRequestDispatcher("/AlterarProduto.jsp");
         rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cod_produto = Integer.parseInt(request.getParameter("cod_produto"));
        float preco = Float.parseFloat(request.getParameter("preco"));
        String descricao = request.getParameter("descricao");
        int qtd_estoque = Integer.parseInt(request.getParameter("qtd_estoque"));
        String nome_produto = request.getParameter("nome_produto");
         Produto produto = ProdutoDAO.getProduto(cod_produto);
         produto.setPreco(preco);
         produto.setDescricao(descricao);
         produto.setQtd_estoque(qtd_estoque);
         produto.setNome_produto(nome_produto);
         
         try {
             ProdutoDAO.updateProduto(produto);
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(AlterarProduto.class.getName()).log(Level.SEVERE, null, ex);
         }
         response.sendRedirect("sucesso.jsp"); 
        
    }

    

}
