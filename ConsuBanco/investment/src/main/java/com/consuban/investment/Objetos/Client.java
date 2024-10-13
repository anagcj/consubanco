package com.consuban.investment.Objetos;  // Asegúrate de que este sea el paquete correcto

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;  // Clave primaria que se generará automáticamente en la base de datos

    private String clientName;
    private String phoneNum;
    private int branchId;

    // Constructor vacío
    public Client() {}

    // Constructor con parámetros
    public Client(int clientId, String clientName, String phoneNum, int branchId) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.phoneNum = phoneNum;
        this.branchId = branchId;
    }

    // Getters y Setters
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
