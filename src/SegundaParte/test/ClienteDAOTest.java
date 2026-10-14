/**
 * @author gustavohmdm
 */

package SegundaParte.test;

import SegundaParte.main.dao.ClienteDAO;
import SegundaParte.main.dao.IClienteDAO;
import SegundaParte.main.domain.Cliente;
import SegundaParte.main.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;

    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDAO = new ClienteDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setNome("Rodrigo");
        cliente.setCpf(12345678910L);
        cliente.setTel(11999999999L);
        cliente.setEnd("Rua X");
        cliente.setNumero(10);
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = this.clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setCpf(56565656565L);
        Boolean retorno = clienteDAO.cadastrar(cliente);
        assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Rodrigo Pires");
        clienteDAO.alterar(cliente);
        Assert.assertEquals("Rodrigo Pires", cliente.getNome());
    }

    public void buscarTodos() {
        Collection<Cliente> list = clienteDAO.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);
    }
}
