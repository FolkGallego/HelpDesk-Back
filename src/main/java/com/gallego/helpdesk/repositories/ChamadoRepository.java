package com.gallego.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gallego.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
