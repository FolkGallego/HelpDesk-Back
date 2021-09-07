package com.gallego.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gallego.helpdesk.domain.Cliente;

public interface PessoaRepository extends JpaRepository<Cliente, Integer>{

}
