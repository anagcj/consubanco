package com.consuban.investment.Servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consuban.investment.Objetos.InterestPlan;
import com.consuban.investment.Repositorio.InterestPlanRepositorio;

@Service
public class InterestPlanServicio {

    @Autowired
    InterestPlanRepositorio interestPlanRepositorio;

    InterestPlan intP = new InterestPlan();

    public InterestPlan saveInterestPlan(InterestPlan interestPlan){        
        if(interestPlanRepositorio.existsById(interestPlan.getIdInterestPlan())){
            return intP;
        }
        else{
            return interestPlanRepositorio.save(interestPlan);
            
        }
    }

    public InterestPlan modificarInterestPlan(InterestPlan interestPlan){
        if(interestPlanRepositorio.existsById(interestPlan.getIdInterestPlan())){
            return interestPlanRepositorio.save(interestPlan);
        }else{
            return intP;
        }
    }
        
    public List<InterestPlan> obtenerInterestPlan(){
        return interestPlanRepositorio.findAll();
    }

    public void eliminarInterestPlan(String idInterestPlan){
        interestPlanRepositorio.deleteById(idInterestPlan);
    }

    
}
