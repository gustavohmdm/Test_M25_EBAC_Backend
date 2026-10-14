/**
 * @author gustavohmdm
 */

package SegundaParte.main.service;

import SegundaParte.main.dao.IClienteDAO;
import SegundaParte.main.domain.Cliente;
import SegundaParte.main.service.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }

    @Override
    public Cliente buscarCPF(Long cpf) {
        return this.dao.consultar(cpf);
    }
}
