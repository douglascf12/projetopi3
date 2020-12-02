/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ProdutoDAO;
import entidade.Funcionario;
import entidade.Produto;
import entidade.Produto.Categoria;
import utils.Utils;
import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tscarton
 */
public class cadastrarProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        float preco = Float.parseFloat(request.getParameter("preco"));
        String descricao = request.getParameter("descricao");
        int qtd_estoque = Integer.parseInt(request.getParameter("qtd_estoque"));
        String nome_produto = request.getParameter("nome_produto");
        String categoria = request.getParameter("categoria");
        HttpSession sessao = request.getSession();
        Funcionario func = (Funcionario) sessao.getAttribute("user");
        int codFilial = func.getCodFilial();
               
        
        Produto produto = new Produto(descricao, nome_produto, qtd_estoque, preco,categoria);
        produto.setCod_filial(codFilial); 
        

        try {
            ProdutoDAO.addProduto(produto);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(cadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }

}
