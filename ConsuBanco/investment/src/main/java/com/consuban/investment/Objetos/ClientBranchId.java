package com.consuban.investment.Objetos;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientBranchId implements Serializable {

    private Long clientId;
    private Long branchId;

    // Constructor vacío
    public ClientBranchId() {}

    // Constructor con parámetros
    public ClientBranchId(Long clientId, Long branchId) {
        this.clientId = clientId;
        this.branchId = branchId;
    }

    // Getters y Setters
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    // Sobrescribir equals y hashCode para que la comparación de objetos funcione correctamente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientBranchId that = (ClientBranchId) o;
        return Objects.equals(clientId, that.clientId) && 
               Objects.equals(branchId, that.branchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, branchId);
    }
}
