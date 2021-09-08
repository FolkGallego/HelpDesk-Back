package com.gallego.helpdesk.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gallego.helpdesk.domain.Tecnico;
import com.gallego.helpdesk.domain.dtos.TecnicoDTO;
import com.gallego.helpdesk.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")//localhost:8080/tecnicos 
public class TecnicoResource {
	
	@Autowired
	private TecnicoService service;
	
	
	//Vamos representar toda Resposta HTTP
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	} 

	//Entra aqui, quando vem uma Requisição sem nenhum Parâmetro
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll() {
		List<Tecnico> list = service.findAll();
		List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
}
