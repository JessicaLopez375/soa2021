package ar.edu.iua.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Cliente;
import ar.edu.iua.model.Factura;
import ar.edu.iua.model.persistence.ClienteRepository;
import ar.edu.iua.model.persistence.FacturaRepository;

@Service
public class ClienteBusiness implements IClienteBusiness{

	@Autowired
	private ClienteRepository clienteDAO;

	@Override
	public Cliente load(Long id) throws NotFoundException, BusinessException {
		Optional<Cliente> op;
		try {
			op=clienteDAO.findById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if(!op.isPresent()) {
			throw new NotFoundException("El producto con id "+id+" no se encuentra en la BD");
		}
		return op.get();
	}

	@Override
	public List<Cliente> list() throws BusinessException {
		try {
			return clienteDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Cliente add(Cliente cliente) throws BusinessException {
		try {
			return clienteDAO.save(cliente);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
