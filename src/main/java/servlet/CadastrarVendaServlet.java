package servlet;

import dao.VendaDAO;
import entidade.Cliente;
import entidade.Funcionario;
import entidade.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastrarVendaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sessao = request.getSession();

        Funcionario funcionario;
        Cliente cliente;
        Float totalVenda = (Float) sessao.getAttribute("valorTotal");
        funcionario = (Funcionario) sessao.getAttribute("user");
        cliente = (Cliente) sessao.getAttribute("cliente");
        
        String dataVenda = "2020-11-14";

        Venda venda = new Venda(cliente.getCpf_cliente(), funcionario.getCpfFunc(), funcionario.getCodFilial(), dataVenda, totalVenda);
        try {
            VendaDAO.finalizarVenda(venda);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("sucesso.jsp");
    }
}
