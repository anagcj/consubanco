package com.consuban.investment.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consuban.investment.Objetos.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
}