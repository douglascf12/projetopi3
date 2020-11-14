package servlet;

import dao.ItemVendaDAO;
import entidade.ItemVenda;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class x_VendaCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idVenda = Integer.parseInt(request.getParameter("idVenda"));
        int codigoFilial = Integer.parseInt(request.getParameter("codigoFilial"));

        List<ItemVenda> listaItemVenda = ItemVendaDAO.getItemVenda(idVenda);

        request.setAttribute("listaItemVenda", listaItemVenda);
        request.setAttribute("idVenda", idVenda);
        request.setAttribute("codigoFilial", codigoFilial);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/vendaCarrinho.jsp");
        rd.forward(request, response);

    }

}
