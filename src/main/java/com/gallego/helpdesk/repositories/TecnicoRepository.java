package com.gallego.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gallego.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
