package servlet;

import dao.ItemVendaDAO;
import entidade.ItemVenda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class x_VendaInserirProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idVenda = Integer.parseInt(request.getParameter("idVenda"));
        int codigoProduto = Integer.parseInt(request.getParameter("codigoProduto"));
        int codigoFilial = Integer.parseInt(request.getParameter("codigoFilial"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double subTotal = Double.parseDouble(request.getParameter("subTotal"));

        try {
            ItemVenda item = new ItemVenda(idVenda, codigoProduto, quantidade, subTotal);
            ItemVendaDAO.inserirItemVenda(item);
            //System.out.println(item.getCodVenda());
            request.setAttribute("codigoFilial", codigoFilial);
            request.setAttribute("idVenda", idVenda);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/vendaProduto.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VendaProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
