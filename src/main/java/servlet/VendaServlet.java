package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import entidade.Cliente;

/**
 * @author Douglas
 */
public class VendaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpf_cliente = request.getParameter("cpf_cliente");
		Cliente cliente = ClienteDAO.getCliente(cpf_cliente);
		request.setAttribute("cliente", cliente);

//        int cod_produto = Integer.parseInt(request.getParameter("cod_produto"));
//        Produto produto = ProdutoDAO.getProduto(cod_produto);
//        request.setAttribute("produto", produto);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/venda.jsp");
		rd.forward(request, response);
	}
	
}
