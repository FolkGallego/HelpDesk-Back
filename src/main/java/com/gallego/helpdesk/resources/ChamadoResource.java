package com.gallego.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gallego.helpdesk.domain.Chamado;
import com.gallego.helpdesk.domain.dtos.ChamadoDTO;
import com.gallego.helpdesk.services.ChamadoService;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource {

	@Autowired
	private ChamadoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id){
		Chamado obj = service.findById(id);
		//Setamos em obj do Chamado e, após, é feita a conversão dos dados e retornado o Objeto de Transferencia da ChamadoDTO
		return ResponseEntity.ok().body(new ChamadoDTO(obj));	
	}
	
}
