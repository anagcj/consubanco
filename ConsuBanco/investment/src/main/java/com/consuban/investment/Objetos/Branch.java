package com.consuban.investment.Objetos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBranch; // Cambiado de branchId a idBranch para que coincida con la base de datos
    private String branchName;
    private String address;

    // Constructor vacío
    public Branch() {}

    // Constructor con parámetros
    public Branch(int idBranch, String branchName, String address) {
        this.idBranch = idBranch;
        this.branchName = branchName;
        this.address = address;
    }

    // Getters y Setters
    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
