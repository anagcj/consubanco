package com.consuban.investment.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consuban.investment.Objetos.Branch;
import com.consuban.investment.Repositorio.BranchRepository;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    // Guardar una branch
    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    // Actualizar una branch existente
    public Branch updateBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    // Obtener una branch por su ID
    public Optional<Branch> getBranch(int branchId) {
        return branchRepository.findById(branchId);
    }


    // Eliminar una branch por su ID
    public void deleteBranch(int branchId) {
        branchRepository.deleteById(branchId);
    }

    // Obtener todas las branches
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }
}
