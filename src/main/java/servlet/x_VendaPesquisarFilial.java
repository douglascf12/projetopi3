package servlet;

import dao.FilialDAO;
import entidade.Filial;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class x_VendaPesquisarFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String cpf = request.getParameter("cpf");
        int codigoFilial = Integer.parseInt(request.getParameter("codigoFilial"));
        
        Filial filial = FilialDAO.getFilial(codigoFilial);
        request.setAttribute("filial", filial);
        request.setAttribute("cpf", cpf);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/vendaFilial.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        request.setAttribute("cpf", cpf);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/vendaFilial.jsp");
        rd.forward(request, response);
    }

}