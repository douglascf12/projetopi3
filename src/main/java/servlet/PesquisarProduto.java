package servlet;

import dao.ProdutoDAO;
import entidade.ItemVenda;
import entidade.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Douglas
 */
public class PesquisarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int cod_produto = Integer.parseInt(request.getParameter("cod_produto"));
        int qtd_produto = Integer.parseInt(request.getParameter("qtd_produto"));

        Produto produto = ProdutoDAO.getProduto(cod_produto);

//        ItemVenda item = new ItemVenda();
//        item.setProduto(produto);
//        item.setQuantidade(qtd_produto);
//
//        itens.add(item);
//
//        request.setAttribute("itens", itens);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/venda.jsp");
        rd.forward(request, response);

    }

}
