package servlet;

import dao.VendaDAO;
import entidade.Cliente;
import entidade.DetalheVenda;
import entidade.Funcionario;
import entidade.Produto;
import entidade.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.dataAtual;

public class CadastrarVendaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sessao = request.getSession();

        Funcionario funcionario;
        Cliente cliente;
        Float totalVenda = Float.parseFloat(request.getParameter("valorTotal"));
        funcionario = (Funcionario) sessao.getAttribute("user");
        cliente = (Cliente) sessao.getAttribute("cliente");

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        String data_venda = formatted;
        
        List<Produto> listaProdutos = (List<Produto>) sessao.getAttribute("listaProdutos");

        Venda venda = new Venda(cliente.getCpf_cliente(), funcionario.getCpfFunc(),data_venda, funcionario.getCodFilial(), totalVenda);
        try {
            int cod_venda = VendaDAO.finalizarVenda(venda);
            System.err.println(cod_venda);
            for (Produto p : listaProdutos) {
                DetalheVenda d = new DetalheVenda(p.getCod_produto(), p.getNome_produto(), cod_venda, p.getQtd_vendida(), p.getSubTotal(), null);
                VendaDAO.finalizarDetalheVenda(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.removeAttribute("listaProdutos");
        response.sendRedirect("sucesso.jsp");
    }
}
