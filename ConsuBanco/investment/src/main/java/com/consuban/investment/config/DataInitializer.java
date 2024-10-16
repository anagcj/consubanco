package com.consuban.investment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.consuban.investment.Objetos.Branch;
import com.consuban.investment.Objetos.Client;
import com.consuban.investment.Objetos.ClientHasBranch;
import com.consuban.investment.Repositorio.BranchRepository;
import com.consuban.investment.Repositorio.ClientHasBranchRepository;
import com.consuban.investment.Repositorio.ClientRepository;
import com.consuban.investment.Objetos.ClientBranchId;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ClientHasBranchRepository clientHasBranchRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verificar y crear el cliente si no existe
        Client client = clientRepository.findById(1L).orElseGet(() -> {
            Client newClient = new Client();
            newClient.setClientName("Nombre del Cliente");
            newClient.setPhoneNum("1234567890");
            newClient.setClientCol("Colonia Cliente");
            return clientRepository.save(newClient); // Hibernate generará el ID automáticamente
        });
        
        // Verificar y crear la sucursal si no existe
        Branch branch = branchRepository.findById(100L).orElseGet(() -> {
            Branch newBranch = new Branch();
            newBranch.setBranchName("Sucursal Principal");
            newBranch.setAddress("Dirección de la Sucursal");
            newBranch.setClient(client); // Asignamos el cliente a la sucursal
            return branchRepository.save(newBranch);
        });

        // Crear la relación entre cliente y sucursal si no existe ya
        if (!clientHasBranchRepository.existsById(new ClientBranchId(client.getIdClient(), branch.getIdBranch()))) {
            ClientHasBranch clientHasBranch = new ClientHasBranch(client, branch);
            clientHasBranchRepository.save(clientHasBranch);
        }
        
    }
}
