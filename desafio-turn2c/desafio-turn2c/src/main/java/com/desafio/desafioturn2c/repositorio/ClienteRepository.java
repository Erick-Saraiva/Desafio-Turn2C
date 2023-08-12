package com.desafio.desafioturn2c.repositorio;

import com.desafio.desafioturn2c.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
