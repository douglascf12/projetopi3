package servlet;

import dao.FuncionarioDAO;
import entidade.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Utils;

public class cadastrarFuncionario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codFilial=-1;
        String cpf = request.getParameter("cpf");
        //int cpf = Integer.parseInt(cpfStr);
        String nome = request.getParameter("nome");
        if (request.getParameter("cod_filial") != null) {
             codFilial = Integer.parseInt(request.getParameter("cod_filial"));
        }
//        String codFiliStr = request.getParameter("cod_filial");
//        int codFili = Integer.parseInt(codFiliStr);
        String cargo = request.getParameter("cargoSelect");
        String telefone = request.getParameter("telefone");
        //int telefone = Integer.parseInt(telefoneStr);
        String endereco = request.getParameter("endereco");
        String dataNasc = request.getParameter("data_nasc");
        String sexo = request.getParameter("sexo");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        Funcionario funcionario = new Funcionario(cpf, nome, codFilial, cargo, telefone, endereco, dataNasc, sexo, usuario, senha);

        try {
            FuncionarioDAO.addFuncionario(funcionario);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(cadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }

    }

}
