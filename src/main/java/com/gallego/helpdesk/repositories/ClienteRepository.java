package com.gallego.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gallego.helpdesk.domain.Pessoa;

public interface ClienteRepository extends JpaRepository<Pessoa, Integer>{

}
