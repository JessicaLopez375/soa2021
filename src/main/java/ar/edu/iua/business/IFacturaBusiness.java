package ar.edu.iua.business;

import java.util.List;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Factura;

public interface IFacturaBusiness {

	public Factura load(Long id) throws NotFoundException, BusinessException;

	public List<Factura> list() throws BusinessException;
	
	public Factura add(Factura factura) throws BusinessException;
	
}
