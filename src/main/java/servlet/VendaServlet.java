package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClienteDAO;
import entidade.Cliente;
import javax.servlet.http.HttpSession;

public class VendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        if(cpf != null && cpf != "") {
            cpf = cpf.replaceAll("[^0-9]", "");
        }
        Cliente cliente = ClienteDAO.getCliente(cpf);
        HttpSession sessao = request.getSession();
        sessao.setAttribute("cliente", cliente);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/venda.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        request.setAttribute("cpf", cpf);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/vendaCarrinho.jsp");
        rd.forward(request, response);
    }
    
}