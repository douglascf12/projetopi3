package servlet;

import dao.FuncionarioDAO;
import entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuário
 */
public class cadastrarFuncionario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpfStr = request.getParameter("cpf_cliente");
        int cpf = Integer.parseInt(cpfStr);
        String nome = request.getParameter("nome");
        String codFiliStr = request.getParameter("cod_filial");
        int codFili = Integer.parseInt(codFiliStr);
        String cargo = request.getParameter("cargo");
        String telefoneStr = request.getParameter("telefone");
        int telefone = Integer.parseInt(telefoneStr);
        String endereco = request.getParameter("endereco");
        String dataNasc = request.getParameter("data_nasc");
        String sexo = request.getParameter("sexo");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        Funcionario funcionario = new Funcionario(cpf, nome , codFili , cargo, telefone, endereco, dataNasc,  sexo , usuario , senha);
        boolean ok = FuncionarioDAO.addFuncionario(funcionario);

        if (ok) {
            response.sendRedirect("sucesso.jsp");
        } else {
            response.sendRedirect("erro.jsp");
        }

    }

}
