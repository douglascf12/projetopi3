/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.RelatorioVendaDAO;
import entidade.Venda;
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
 * @author w_olv
 */
public class ListarVendas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Venda> vendas = null;
        try {
            vendas = RelatorioVendaDAO.getRelatorioVenda();
        } catch (SQLException ex) {
            Logger.getLogger(ListarVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("listaVendas", vendas);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/RelatorioVenda.jsp");
        requestDispatcher.forward(request, response);
    }
}
