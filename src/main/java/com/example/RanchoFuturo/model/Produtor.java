package com.example.RanchoFuturo.model;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Produtor extends Usuario {

    @Column(name = "cnpj", nullable = false)
    private String cnpj;
    @Column(name = "Razao_Social", nullable = false)
    private String razaoSocial;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Produtor{" +
                "cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                '}';
    }
}
