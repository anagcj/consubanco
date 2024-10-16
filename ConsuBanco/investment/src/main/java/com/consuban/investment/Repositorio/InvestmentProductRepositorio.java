package com.consuban.investment.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consuban.investment.Objetos.InvestmentProduct;

@Repository
public interface InvestmentProductRepositorio extends JpaRepository<InvestmentProduct,String> {

    
}
