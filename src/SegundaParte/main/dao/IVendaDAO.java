package SegundaParte.main.dao;

import SegundaParte.main.dao.generic.IGenericDAO;
import SegundaParte.main.domain.Venda;
import SegundaParte.main.exception.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
