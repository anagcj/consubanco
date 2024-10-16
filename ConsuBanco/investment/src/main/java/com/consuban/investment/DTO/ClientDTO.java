package com.consuban.investment.DTO;

public class ClientDTO {

    private Long idClient;
    private String clientName;
    private String phoneNum;
    private String clientCol;

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

    // Getter y Setter para clientCol
    public String getClientCol() {
        return clientCol;
    }

    public void setClientCol(String clientCol) {
        this.clientCol = clientCol;
    }
}
