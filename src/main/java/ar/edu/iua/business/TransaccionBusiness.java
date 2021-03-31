package ar.edu.iua.business;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Factura;
import ar.edu.iua.model.Transaccion;
import ar.edu.iua.model.persistence.FacturaRepository;
import ar.edu.iua.model.persistence.TransaccionRepository;

@Service
public class TransaccionBusiness implements ITransaccionBusiness{

	@Autowired
	private TransaccionRepository transaccionDAO;
	
	ClienteBusiness clienteBusiness; 
	FacturaBusiness facturaBusiness; 

	@Override
	public Transaccion load(Long id) throws NotFoundException, BusinessException {
		Optional<Transaccion> op;
		try {
			op=transaccionDAO.findById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if(!op.isPresent()) {
			throw new NotFoundException("La transaccion con id "+id+" no se encuentra en la BD");
		}
		return op.get();
	}

	@Override
	public List<Transaccion> list() throws BusinessException {
		try {
			return transaccionDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Transaccion add(Transaccion transaccion) throws BusinessException {
		try {
			return transaccionDAO.save(transaccion);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	

}
