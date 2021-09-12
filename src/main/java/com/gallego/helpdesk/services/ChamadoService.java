package com.gallego.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gallego.helpdesk.domain.Chamado;
import com.gallego.helpdesk.domain.Cliente;
import com.gallego.helpdesk.domain.Tecnico;
import com.gallego.helpdesk.domain.dtos.ChamadoDTO;
import com.gallego.helpdesk.domain.enums.Prioridade;
import com.gallego.helpdesk.domain.enums.Status;
import com.gallego.helpdesk.repositories.ChamadoRepository;
import com.gallego.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}
	

	public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		//oldObj está com as informações desatualizadas, o objDTO está com elas atualizadas
		Chamado oldObj = findById(id);
		//Aqui vai para o Método newChamado(objDTO) oldObj recebe essas informações atualizadas
		oldObj = newChamado(objDTO); 
		//Aqui o oldObj já está com as informações atualizadas
		return repository.save(oldObj);
	}

	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());

		Chamado chamado = new Chamado();
		//O update Chama este Método, se for diferente de nulo cai aqui, ou seja, (Quer Atualizar) 
		//Quando chegar no (save) o JPA vai entender que é uma atualização e vai apenas "Trocar" as informações
		if (obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		if (obj.getStatus().equals(2)) {
			chamado.setDataFechamento(LocalDate.now());
		}

		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;

	}

}
