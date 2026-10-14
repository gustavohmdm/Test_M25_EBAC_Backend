/**
 * @author gustavohmdm
 */

package SegundaParte.test;

import SegundaParte.main.dao.IProdutoDAO;
import SegundaParte.main.dao.ProdutoDAO;
import SegundaParte.main.domain.Produto;
import SegundaParte.main.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDAO;

    private Produto produto;

    public ProdutoDAOTest() {
        produtoDAO = new ProdutoDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produtoDAO.cadastrar(produto);
    }

    @Test
    public void pesquisar() {
        Produto produto = this.produtoDAO.consultar(this.produto.getCodigo());
        Assert.assertNotNull(produto);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        produto.setCodigo("A2");
        Boolean retorno = produtoDAO.cadastrar(produto);
        assertTrue(retorno);
    }

    @Test
    public void excluir() {
        produtoDAO.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Rodrigo Pires");
        produtoDAO.alterar(produto);

        Assert.assertEquals("Rodrigo Pires", produto.getNome());
    }

    @Test
    public void buscarTodos() {
        Collection<Produto> list = produtoDAO.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);
    }
}
