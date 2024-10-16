package com.consuban.investment.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consuban.investment.Objetos.InvestmentProduct;
import com.consuban.investment.Servicio.InvestmentProductServicio;

@RestController
@RequestMapping("/investmentProduct")
public class InvestmentProductControlador {

    @Autowired
    InvestmentProductServicio investmentProductServicio;

    @PostMapping("/saveInvestmentProduct")
    public InvestmentProduct saveInvestmentProduct(@RequestBody InvestmentProduct investmentProduct){        
        return investmentProductServicio.saveInvestmentProduct(investmentProduct);    
    }

    @PutMapping("/modificarInvestmentProduct")
    public InvestmentProduct modificarInvestmentProduct(@RequestBody InvestmentProduct investmentProduct){
        return investmentProductServicio.modificarInvestmentProduct(investmentProduct);
    }

    @GetMapping("/obtenerInvestmentProduct")
    public List<InvestmentProduct> obtenerInvestmentProduct(){
        return investmentProductServicio.obtenerInvestmentProduct();
    }

    @DeleteMapping("/eliminarInvestmentProduct")
    public void eliminarinvestmentProduct(@RequestParam String idProduct){
        investmentProductServicio.eliminarinvestmentProduct(idProduct);
    }
    
}
