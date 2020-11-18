/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.RelatorioVendaDAO;
import entidade.DetalheVenda;
import entidade.ItemVenda;
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
public class DetalharVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_venda = Integer.parseInt(request.getParameter("id_venda"));
        List<DetalheVenda> detalheVendas = null;
        try {
            detalheVendas = RelatorioVendaDAO.getDetalheRelatorioVenda(id_venda);
        } catch (SQLException ex) {
            Logger.getLogger(ListarVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("listaDetalheVendas", detalheVendas);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/RelatorioDetalheVenda.jsp");
        requestDispatcher.forward(request, response);
    }
}
