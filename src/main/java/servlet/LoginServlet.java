package servlet;

import dao.FilialDAO;
import dao.FuncionarioDAO;
import entidade.Filial;
import entidade.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        Funcionario user = FuncionarioDAO.getFuncLogin(usuario);
        int codFilial = user.getCodFilial();
        Filial f = FilialDAO.getFilial(codFilial);
        if(user == null || !user.validarSenha(senha)) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?erro=login");
        } else {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("user", user);
            sessao.setAttribute("f", f);
            response.sendRedirect(request.getContextPath() + "/protegido/index.jsp");
        }
    }

}
