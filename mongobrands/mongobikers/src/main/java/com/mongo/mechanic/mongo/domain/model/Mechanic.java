package com.mongo.mechanic.mongo.domain.model;

public class Mechanic {

    private String id;
    private String nameMechanical;

    private String Email;

    private String numberPhone;
    private String specialSkillBrand;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameMechanical() {
        return nameMechanical;
    }

    public void setNameMechanical(String nameMechanical) {
        this.nameMechanical = nameMechanical;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getSpecialSkillBrand() {
        return specialSkillBrand;
    }

    public void setSpecialSkillBrand(String specialSkillBrand) {
        this.specialSkillBrand = specialSkillBrand;
    }

    public Mechanic(String id, String nameMechanical, String email, String numberPhone, String specialSkillBrand) {
        this.id = id;
        this.nameMechanical = nameMechanical;
        Email = email;
        this.numberPhone = numberPhone;
        this.specialSkillBrand = specialSkillBrand;
    }

    public Mechanic() {
    }
}
