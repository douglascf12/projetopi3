package servlet;

import dao.FuncionarioDAO;
import entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        Funcionario funcionario = FuncionarioDAO.getFunc(nome);

        request.setAttribute("funcionario", funcionario);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AlterarFuncionario.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpfStr = request.getParameter("cpf_func");
        int cpf = Integer.parseInt(cpfStr);
        String nome = request.getParameter("nome");
        String codFiliStr = request.getParameter("cod_filial");
        int codFili = Integer.parseInt(codFiliStr);
        String cargo = request.getParameter("cargo");
        String telefoneStr = request.getParameter("telefone"); 
        int telefone = Integer.parseInt(telefoneStr);
        String endereco = request.getParameter("endereco");
        String datanasc = request.getParameter("data_nasc"); 
        String sexo = request.getParameter("sexo");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        Funcionario funcionario = FuncionarioDAO.getFunc(nome);
        
        funcionario.setCpfFunc(cpf);
        funcionario.setNomeFunc(nome);
        funcionario.setCodFilial(codFili);
        funcionario.setCargo(cargo);
        funcionario.setTelefoneFunc(telefone);
        funcionario.setEnderecoFunc(endereco);
        funcionario.setDataNascFunc(datanasc);
        funcionario.setSexoFunc(sexo);
        funcionario.setUsuario(usuario);
        funcionario.setSenha(senha);
        
        FuncionarioDAO.updateFuncionario(funcionario);
        response.sendRedirect("sucesso.jsp");
        
    }

}
