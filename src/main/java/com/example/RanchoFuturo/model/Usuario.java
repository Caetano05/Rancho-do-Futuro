package com.example.RanchoFuturo.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Usuario extends EntityId {
    private String nome;

    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}

