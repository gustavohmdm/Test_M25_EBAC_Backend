/**
 * @author gustavohmdm
 */

package SegundaParte.main.service;

import SegundaParte.main.domain.Cliente;
import SegundaParte.main.exception.TipoChaveNaoEncontradaException;

public interface IClienteService {

    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}

