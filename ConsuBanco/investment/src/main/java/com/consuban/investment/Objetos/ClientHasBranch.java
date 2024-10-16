package com.consuban.investment.Objetos;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client_has_branch")
public class ClientHasBranch implements Serializable {

    @EmbeddedId
    private ClientBranchId id;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @MapsId("branchId")
    @JoinColumn(name = "branch_id")
    private Branch branch;

    // Constructor sin parámetros
    public ClientHasBranch() {}

    // Constructor con parámetros
    public ClientHasBranch(Client client, Branch branch) {
        this.client = client;
        this.branch = branch;
        this.id = new ClientBranchId(client.getIdClient(), branch.getIdBranch());
    }

    // Getters y Setters
    public ClientBranchId getId() {
        return id;
    }

    public void setId(ClientBranchId id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
