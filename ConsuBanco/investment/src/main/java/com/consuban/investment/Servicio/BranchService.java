package com.consuban.investment.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consuban.investment.DTO.BranchDTO;
import com.consuban.investment.Objetos.Branch;
import com.consuban.investment.Repositorio.BranchRepository;
import com.consuban.investment.Repositorio.ClientRepository;

import com.consuban.investment.Objetos.Client;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Branch createBranch(Long clientId, Branch branch) throws Exception {
        // Buscamos el cliente relacionado
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new Exception("Client not found"));

        // Asignamos el cliente a la sucursal
        branch.setClient(client);

        // Guardamos la sucursal en la base de datos
        return branchRepository.save(branch);
    }
    
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    public Optional<Branch> getBranchById(Long id) {
        return branchRepository.findById(id);
    }

    // Guardar una nueva sucursal
    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public Branch updateBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

    public Branch convertToEntity(BranchDTO branchDTO) {
        Branch branch = new Branch();
        branch.setIdBranch(branchDTO.getId()); // Usamos idBranch
        branch.setBranchName(branchDTO.getBranchName());
        branch.setAddress(branchDTO.getAddress());
        return branch;
    }
    
    public BranchDTO convertToDTO(Branch branch) {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setId(branch.getIdBranch()); // Usamos getIdBranch()
        branchDTO.setBranchName(branch.getBranchName());
        branchDTO.setAddress(branch.getAddress());
        return branchDTO;
    }
}
