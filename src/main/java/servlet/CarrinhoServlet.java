package servlet;

import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();

        int codProduto = Integer.parseInt(request.getParameter("codigo"));
        int qtdVendida = Integer.parseInt(request.getParameter("qtdVendida"));
        float subTotal = Float.parseFloat(request.getParameter("subTotal"));
        
        Produto produto = ProdutoDAO.getProduto(codProduto);
        produto.setQtd_vendida(qtdVendida);
        produto.setSubTotal(subTotal);

        List<Produto> listaProdutos;
        if(sessao.getAttribute("listaProdutos") == null) {
            listaProdutos = new ArrayList<>();
        } else {
            listaProdutos = (List<Produto>) sessao.getAttribute("listaProdutos");
        }
        
        boolean contem = false;
        for(Produto p: listaProdutos) {
            if(p.getCod_produto() == codProduto) {
                contem = true;
                break;
            }
        }
        if(!contem) {
            listaProdutos.add(produto);
        }

        sessao.setAttribute("listaProdutos", listaProdutos);
    }

}