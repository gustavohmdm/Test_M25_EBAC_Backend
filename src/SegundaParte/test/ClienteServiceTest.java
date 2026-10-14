/**
 * @author gustavohmdm
 */

package SegundaParte.test;

import SegundaParte.test.dao.ClienteDAOMock;
import SegundaParte.main.dao.IClienteDAO;
import SegundaParte.main.domain.Cliente;
import SegundaParte.main.exception.TipoChaveNaoEncontradaException;
import SegundaParte.main.service.ClienteService;
import SegundaParte.main.service.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO DAO = new ClienteDAOMock();
        clienteService = new ClienteService(DAO);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setNome("Rodrigo");
        cliente.setCpf(12345678910L);
        cliente.setTel(11999999999L);
        cliente.setEnd("Rua X");
        cliente.setNumero(10);
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Rodrigo Pires");
        clienteService.alterar(cliente);
        Assert.assertEquals("Rodrigo Pires", cliente.getNome());
    }
}
