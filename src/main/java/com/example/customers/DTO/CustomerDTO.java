package com.example.customers.DTO;

public class CustomerDTO {
    private Long clientId;
    private String name;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(Long clientId, String name, String email) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
