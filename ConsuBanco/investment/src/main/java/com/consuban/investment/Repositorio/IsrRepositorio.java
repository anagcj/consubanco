package com.consuban.investment.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consuban.investment.Objetos.Isr;

@Repository
public interface IsrRepositorio extends JpaRepository<Isr,String>{

    
}


