
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
        String dataNasc = request.getParameter("data_nasc");
        String telefoneStr = request.getParameter("telefone");
        int telefone = Integer.parseInt(telefoneStr);
        String endereco = request.getParameter("endereco");
        String sexo = request.getParameter("sexo");
        
        Funcionario funcionario = new Funcionario (cpf , nome , dataNasc , telefone , endereco , sexo);
        boolean ok = FuncionarioDAO.addFuncionario(funcionario);
        
         if (ok){
        response.sendRedirect("sucesso.jsp");
        }else {
            response.sendRedirect("erro.jsp");
        }
        
    }

   

}
