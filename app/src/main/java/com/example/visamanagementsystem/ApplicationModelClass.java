package com.example.visamanagementsystem;

public class ApplicationModelClass {
    Integer id;
    String name;
    String email;
    String res_country;
    String dob;
    String pov;
    String dot;
    String doi;
    String doe;
    public ApplicationModelClass(String name, String email, String res_country, String dob, String pov, String dot, String doi, String doe) {
        this.name=name;
        this.email=email;
        this.res_country=res_country;
        this.dob=dob;
        this.pov=pov;
        this.dot=dot;
        this.doi=doi;
        this.doe=doe;
    }


    public ApplicationModelClass(Integer id, String name, String email, String res_country, String dob, String pov, String dot, String doi, String doe) {
    this.id=id;
    this.name=name;
    this.email=email;
    this.res_country=res_country;
    this.dob=dob;
    this.pov=pov;
    this.dot=dot;
    this.doi=doi;
    this.doe=doe;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRes_country() {
        return res_country;
    }

    public void setRes_country(String res_country) {
        this.res_country = res_country;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPov() {
        return pov;
    }

    public void setPov(String pov) {
        this.pov = pov;
    }

    public String getDot() {
        return dot;
    }

    public void setDot(String dot) {
        this.dot = dot;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getDoe() {
        return doe;
    }

    public void setDoe(String doe) {
        this.doe = doe;
    }

}