package servlet;

import dao.VendaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaFinalizar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codVenda = Integer.parseInt(request.getParameter("idVenda"));
        double valorTotal = Double.parseDouble(request.getParameter("valorTotal"));
        VendaDAO.finalizarVenda(valorTotal, codVenda);
        response.sendRedirect("sucesso.jsp");
    }

}
