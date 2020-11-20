
package servlet;

import dao.FuncionarioDAO;
import entidade.Funcionario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Funcionario> funcionario = FuncionarioDAO.getFuncionario();
        request.setAttribute("listaFuncionarios", funcionario);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/admin/listarFuncionarios.jsp");
        
        rd.forward(request, response);
    }

   
}
