package servlet;

import dao.FilialDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        try {
            FilialDAO.deletarFilial(codigo);
            response.getWriter().print(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ExcluirProduto.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().print(false);
        }

    }

}