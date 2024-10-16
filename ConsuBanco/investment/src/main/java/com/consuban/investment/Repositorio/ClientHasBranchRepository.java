package com.consuban.investment.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.consuban.investment.Objetos.ClientHasBranch;
import com.consuban.investment.Objetos.ClientBranchId;

public interface ClientHasBranchRepository extends JpaRepository<ClientHasBranch, ClientBranchId> {
}