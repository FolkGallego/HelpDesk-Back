package com.gallego.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gallego.helpdesk.domain.Chamado;
import com.gallego.helpdesk.domain.Cliente;
import com.gallego.helpdesk.domain.Tecnico;
import com.gallego.helpdesk.domain.enums.Perfil;
import com.gallego.helpdesk.domain.enums.Prioridade;
import com.gallego.helpdesk.domain.enums.Status;
import com.gallego.helpdesk.repositories.ChamadoRepository;
import com.gallego.helpdesk.repositories.ClienteRepository;
import com.gallego.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "João Gallego", "40586987503", "joaogallego@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Marcos Costa", "70585965806", "marcos@gmail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
		
		
	}

}
