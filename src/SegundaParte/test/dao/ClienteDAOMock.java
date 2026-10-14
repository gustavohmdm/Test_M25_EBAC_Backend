/**
 * @author gustavohmdm
 */

package SegundaParte.test.dao;

import SegundaParte.main.dao.IClienteDAO;
import SegundaParte.main.domain.Cliente;
import SegundaParte.main.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class ClienteDAOMock implements IClienteDAO {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }
}
