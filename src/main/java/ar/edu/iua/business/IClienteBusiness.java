package ar.edu.iua.business;

import java.util.List;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Cliente;
import ar.edu.iua.model.Factura;

public interface IClienteBusiness {

	public Cliente load(Long id) throws NotFoundException, BusinessException;

	public List<Cliente> list() throws BusinessException;
	
	public Cliente add(Cliente cliente) throws BusinessException;
}
