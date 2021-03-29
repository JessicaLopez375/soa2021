package ar.edu.iua.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.iua.model.Cliente;
import ar.edu.iua.model.Factura;
import ar.edu.iua.model.Transaccion;

//https://docs.spring.io/spring-data/jpa/docs/2.3.2.RELEASE/reference/html/#repositories.query-methods.details

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{
	
}

