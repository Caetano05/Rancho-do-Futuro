package com.example.RanchoFuturo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Consumidor extends Usuario{


    @Column(name = "cpf", nullable = false)
    private String cpf;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Consumidor{" +
                "cpf='" + cpf + '\'' +
                '}';
    }
}
