package com.consuban.investment.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consuban.investment.Objetos.Client;
import com.consuban.investment.Repositorio.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public void updateClient(Client client) {
        clientRepository.save(client);  // save puede servir para actualizar si el cliente ya existe
    }

    public Client getClient(int clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    public void deleteClient(int clientId) {
        clientRepository.deleteById(clientId);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
