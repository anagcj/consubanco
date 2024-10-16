package com.consuban.investment.Servicio;

import com.consuban.investment.Objetos.Client;
import com.consuban.investment.Objetos.Branch;
import com.consuban.investment.Objetos.ClientHasBranch;
import com.consuban.investment.Repositorio.ClientRepository;
import com.consuban.investment.Repositorio.BranchRepository;
import com.consuban.investment.Repositorio.ClientHasBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClientHasBranchService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ClientHasBranchRepository clientHasBranchRepository;

    public ClientHasBranch saveClientBranchRelation(Long clientId, Long branchId) {
        // Verificar si el cliente existe
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NoSuchElementException("Client not found with id: " + clientId));
    
        // Verificar si la sucursal existe
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new NoSuchElementException("Branch not found with id: " + branchId));
    
        // Crear la relación
        ClientHasBranch clientHasBranch = new ClientHasBranch(client, branch);
    
        // Guardar la relación
        return clientHasBranchRepository.save(clientHasBranch);
    }
}    