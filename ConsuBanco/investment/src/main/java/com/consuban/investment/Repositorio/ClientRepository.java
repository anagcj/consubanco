package com.consuban.investment.Repositorio;

import com.consuban.investment.Objetos.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}