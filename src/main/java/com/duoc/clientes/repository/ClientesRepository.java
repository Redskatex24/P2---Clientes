package com.duoc.clientes.repository;

import com.duoc.clientes.model.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, Integer> {}
