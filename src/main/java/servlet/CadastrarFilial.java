package servlet;

import dao.FilialDAO;
import entidade.Filial;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Utils;

public class CadastrarFilial extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");

        Filial filial = new Filial(nome, estado, cidade);

        try {
            FilialDAO.addFilial(filial);
            Utils.mostrarTelaSucesso(response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(cadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }

}