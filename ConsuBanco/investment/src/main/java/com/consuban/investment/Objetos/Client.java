package com.consuban.investment.Objetos;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    
    private String clientName;
    private String phoneNum;
    private String clientCol;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Branch> branches = new ArrayList<>();  // Inicializamos la lista

    // Getters y Setters

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getClientCol() {
        return clientCol;
    }

    public void setClientCol(String clientCol) {
        this.clientCol = clientCol;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    // Método para añadir sucursales al cliente y mantener la coherencia bidireccional
    public void addBranch(Branch branch) {
        branches.add(branch);
        branch.setClient(this);  // Establece la relación en ambas direcciones
    }
}
