package ar.edu.iua.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.iua.business.IFacturaBusiness;
import ar.edu.iua.business.ITransaccionBusiness;
import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Factura;
import ar.edu.iua.model.Transaccion;

@RestController
@RequestMapping(value = Constantes.URL_TRANSACCIONES)
public class TansaccionRestController {

	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ITransaccionBusiness transaccionBusiness;

	// curl "http://localhost:8080/api/v1/productos/1" -v
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transaccion> load(@PathVariable("id") Long id) {

		try {
			return new ResponseEntity<Transaccion>(transaccionBusiness.load(id), HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<Transaccion>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity<Transaccion>(HttpStatus.NOT_FOUND);
		}
	}

	// curl "http://localhost:8080/api/v1/productos"
	// curl "http://localhost:8080/api/v1/productos?parte=arga"
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transaccion>> list() {
		try {
				return new ResponseEntity<List<Transaccion>>(transaccionBusiness.list(), HttpStatus.OK);
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<List<Transaccion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// curl -X POST "http://localhost:8080/api/v1/productos" -H "Content-Type:
	// application/json" -d '{"nombre":"Leche","descripcion":"Larga
	// Vida","precioLista":69,"enStock":true}' -v
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@RequestBody Transaccion Transaccion) {
		try {
			transaccionBusiness.add(Transaccion);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", Constantes.URL_TRANSACCIONES + "/" + Transaccion.getId());
			return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}