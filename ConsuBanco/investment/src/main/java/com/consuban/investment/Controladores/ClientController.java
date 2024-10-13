package com.consuban.investment.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;  // Import necesario para PUT
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consuban.investment.Objetos.Client;
import com.consuban.investment.Servicio.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/saveClient")
    public void saveClient(@RequestBody Client client) {
        clientService.saveClient(client);
    }

    @PutMapping("/updateClient")  // Método para manejar la actualización
    public void updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
    }

    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable int clientId) {
        return clientService.getClient(clientId);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable int clientId) {
        clientService.deleteClient(clientId);
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
}
