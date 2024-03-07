package com.example.RanchoFuturo.model;

import net.bytebuddy.asm.Advice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Pedido extends EntityId {

    @ManyToOne
    @JoinColumn(name = "Produtor")
    private Produtor produtor;
    @ManyToOne
    @JoinColumn(name = "Produto")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "Consumidor")
    private Consumidor consumidor;


    @Column(name = "Data", nullable = false)
    private LocalDate data;

    @Column(name = "Descricao", nullable = false)
    private String descricao;

    public Pedido(){
        this.data = LocalDate.now();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "produtor=" + produtor +
                ", produto=" + produto +
                ", consumidor=" + consumidor +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
