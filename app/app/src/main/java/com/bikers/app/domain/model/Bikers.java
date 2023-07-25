package com.bikers.app.domain.model;

public class Bikers {
    private Long id;
    private String name;
    private String emailAddress;
    private String mechanic;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
    }

    public Bikers() {
    }

    public Bikers(Long id, String name, String emailAddress, String mechanic) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.mechanic = mechanic;
    }
}
