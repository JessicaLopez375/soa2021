package ar.edu.iua.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Factura;
import ar.edu.iua.model.persistence.FacturaRepository;

@Service
public class FacturaBusiness implements IFacturaBusiness{
	
	@Autowired
	private FacturaRepository facturaDAO;

	@Override
	public Factura load(Long id) throws NotFoundException, BusinessException {
		Optional<Factura> op;
		try {
			op=facturaDAO.findById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if(!op.isPresent()) {
			throw new NotFoundException("El producto con id "+id+" no se encuentra en la BD");
		}
		return op.get();
	}

	@Override
	public List<Factura> list() throws BusinessException {
		try {
			return facturaDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Factura add(Factura factura) throws BusinessException {
		try {
			return facturaDAO.save(factura);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
