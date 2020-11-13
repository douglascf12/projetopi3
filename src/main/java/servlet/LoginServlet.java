package servlet;

import dao.FuncionarioDAO;
import entidade.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        //HttpSession sessao = httpRequest.getSession();

        Funcionario user = FuncionarioDAO.getFunc(usuario, senha);
        if(user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?erro=login");
        } else {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/protegido/index.jsp");
        }

    }
}
