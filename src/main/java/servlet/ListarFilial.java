package servlet;

import dao.FilialDAO;
import entidade.Filial;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Filial> listaFiliais = FilialDAO.getFiliais();
        request.setAttribute("listaFiliais", listaFiliais);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/admin/listarFiliais.jsp");
        rd.forward(request, response);
    }

}