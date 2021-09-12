package com.gallego.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "João Gallego", "752.200.500-01", "joaogallego@gmail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Matheus silva", "210.692.810-69", "matheus@gmail.com", encoder.encode("123"));
		tec2.addPerfil(Perfil.TECNICO);
		Tecnico tec3 = new Tecnico(null, "Gustavo Lima", "841.415.210-43", "gustavo@gmail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Paulo Guedes", "141.597.910-34", "paulo@gmail.com", encoder.encode("123"));
		Tecnico tec5 = new Tecnico(null, "Taldo Costa", "118.555.110-70", "taldocosta@gmail.com", encoder.encode("123"));
		Tecnico tec6 = new Tecnico(null, "Lucas de Mori", "430.183.620-98", "demori@gmail.com", encoder.encode("123"));
		
		Cliente cli1 = new Cliente(null, "Marcos Costa", "874.392.810-20", "marcos@gmail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Lais Silva", "903.408.630-56", "lais@gmail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Lucas Spinelli", "843.373.400-84", "spinelli@gmail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Gabriela alarcomn", "269.730.800-81", "gabislar@gmail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Adriana Braga", "222.593.450-93", "adriana@gmail.com", encoder.encode("123"));
		Cliente cli6 = new Cliente(null, "Camila Lourelço", "752.996.570-05", "camilaLou@gmail.com", encoder.encode("123"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02", "Segundo Chamado", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 03", "Terceiro Chamado", tec3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 04", "Quarto Chamado", tec4, cli4);
		Chamado c5 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 05", "Quinto Chamado", tec5, cli5);
		Chamado c6 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 06", "Sexto Chamado", tec1, cli5);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6)); 
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
	}
}
