/**
 * @author gustavohmdm
 */

package SegundaParte.main.service;

import SegundaParte.main.dao.IProdutoDAO;
import SegundaParte.main.domain.Produto;
import SegundaParte.main.service.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }


    @Override
    public Produto buscarCodigo(String codigo) {
        return this.dao.consultar(codigo);
    }
}
