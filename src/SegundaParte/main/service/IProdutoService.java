/**
 * @author gustavohmdm
 */

package SegundaParte.main.service;

import SegundaParte.main.domain.Produto;
import SegundaParte.main.service.generic.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String> {

    Produto buscarCodigo(String codigo);
}
