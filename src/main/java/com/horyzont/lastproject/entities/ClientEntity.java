package com.horyzont.lastproject.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="client_name")
    private  String client_name;

    @Column(name = "email")
    private String email;

    public  Integer getId(){return id;}

    public  String getClient_name(){return client_name;}

    public  String getEmail(){return email;}

    public void setId(Integer id) {this.id = id;}

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
