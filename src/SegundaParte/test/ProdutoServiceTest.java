/**
 * @author gustavohmdm
 */

package SegundaParte.test;

import SegundaParte.main.dao.IProdutoDAO;
import SegundaParte.main.domain.Produto;
import SegundaParte.main.exception.TipoChaveNaoEncontradaException;
import SegundaParte.main.service.IProdutoService;
import SegundaParte.main.service.ProdutoService;
import SegundaParte.test.dao.ProdutoDAOMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoServiceTest {

    private IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO DAO = new ProdutoDAOMock();
        produtoService = new ProdutoService(DAO);
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
    }

    @Test
    public void pesquisar() {
        Produto produtoConsultado = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluir() {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Rodrigo Pires");
        produtoService.alterar(produto);

        Assert.assertEquals("Rodrigo Pires", produto.getNome());
    }
}
