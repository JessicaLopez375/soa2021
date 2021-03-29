package ar.edu.iua.business;

import java.util.List;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Factura;
import ar.edu.iua.model.Transaccion;

public interface ITransaccionBusiness {
	public Transaccion load(Long id) throws NotFoundException, BusinessException;

	public List<Transaccion> list() throws BusinessException;
	
	public Transaccion add(Transaccion transaccion) throws BusinessException;
}
