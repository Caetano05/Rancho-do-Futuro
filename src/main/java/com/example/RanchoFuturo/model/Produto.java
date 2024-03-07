package com.example.RanchoFuturo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto extends EntityId {

    @Column(name = "Nome", nullable = false)
    private String nome;
    @Column(name = "Descricao", nullable = false)
    private String descricao;
    @Column(name = "Quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "Valor", nullable = false)
    private Double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}
