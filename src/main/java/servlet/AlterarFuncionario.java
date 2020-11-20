package servlet;

import dao.FuncionarioDAO;
import entidade.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cpf = request.getParameter("cpf");
        Funcionario func = FuncionarioDAO.getFunc(cpf);

        request.setAttribute("func", func);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/protegido/admin/alterarFuncionario.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        int codFilial = Integer.parseInt(request.getParameter("cod_filial"));
        String cargo = request.getParameter("cargo");
        String telefone = request.getParameter("telefone"); 
        String endereco = request.getParameter("endereco");
        String datanasc = request.getParameter("data_nasc"); 
        String sexo = request.getParameter("sexo");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        Funcionario func = FuncionarioDAO.getFunc(cpf);
        func.setCpfFunc(cpf);
        func.setNomeFunc(nome);
        func.setCodFilial(codFilial);
        func.setCargo(cargo);
        func.setTelefoneFunc(telefone);
        func.setEnderecoFunc(endereco);
        func.setDataNascFunc(datanasc);
        func.setSexoFunc(sexo);
        func.setUsuario(usuario);
        func.setSenha(senha);
        
        try {
            FuncionarioDAO.updateFuncionario(func);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("sucesso.jsp");
    }
    
}