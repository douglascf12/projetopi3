package servlet;

import dao.FilialDAO;
import entidade.Filial;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        Filial filial = FilialDAO.getFilial(codigo);
        request.setAttribute("filial", filial);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/admin/alterarFilial.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");

        Filial filial = FilialDAO.getFilial(codigo);
        filial.setNome(nome);
        filial.setEstado(estado);
        filial.setCidade(cidade);

        try {
            FilialDAO.updateFilial(filial);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlterarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("sucesso.jsp");
    }

}