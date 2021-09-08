package com.gallego.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gallego.helpdesk.domain.Chamado;
import com.gallego.helpdesk.domain.Cliente;
import com.gallego.helpdesk.domain.Tecnico;
import com.gallego.helpdesk.domain.enums.Perfil;
import com.gallego.helpdesk.domain.enums.Prioridade;
import com.gallego.helpdesk.domain.enums.Status;
import com.gallego.helpdesk.repositories.ChamadoRepository;
import com.gallego.helpdesk.repositories.ClienteRepository;
import com.gallego.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "João Gallego", "40586987503", "joaogallego@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Matheus silva", "404.856.758-07", "matheus@gmail.com", "123");
		tec2.addPerfil(Perfil.TECNICO);
		Tecnico tec3 = new Tecnico(null, "Gustavo Lima", "111.786.668-07", "gustavo@gmail.com", "123");
		Tecnico tec4 = new Tecnico(null, "Paulo Guedes", "888.458.695-02", "paulo@gmail.com", "123");
		Tecnico tec5 = new Tecnico(null, "Taldo Costa", "568.458.457.11", "taldocosta@gmail.com", "123");
		
		
		Cliente cli1 = new Cliente(null, "Marcos Costa", "70585965806", "marcos@gmail.com", "123");
		Cliente cli2 = new Cliente(null, "Lais Silva", "758.659.451.05", "lais@gmail.com", "123");
		Cliente cli3 = new Cliente(null, "Lucas Spinelli", "869.458.222.05", "spinelli@gmail.com", "123");
		Cliente cli4 = new Cliente(null, "Gabriela alarcomn", "968.458.222.45", "gabislar@gmail.com", "123");
		Cliente cli5 = new Cliente(null, "Adriana Braga", "778.568.484.55", "adriana@gmail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02", "Segundo Chamado", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 03", "Terceiro Chamado", tec3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 04", "Quarto Chamado", tec4, cli4);
		Chamado c5 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 05", "Quinto Chamado", tec5, cli5);
		Chamado c6 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 06", "Sexto Chamado", tec1, cli5);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
	}
}
