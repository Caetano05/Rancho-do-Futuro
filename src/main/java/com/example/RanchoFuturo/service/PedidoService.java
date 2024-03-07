package com.example.RanchoFuturo.service;

import com.example.RanchoFuturo.model.Pedido;
import com.example.RanchoFuturo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repositoryPedido;
    public Pedido salvar(Pedido entity) { return repositoryPedido.save(entity);}

    public List<Pedido> buscaTodos() {return  repositoryPedido.findAll();}

    public Pedido buscaPorId(Long id){
        return  repositoryPedido.findById(id).orElse(null);
    }
    public Pedido alterar(Long id, Pedido alterado) {
        Optional<Pedido> encontrado = repositoryPedido.findById(id);
        if(encontrado.isPresent()){
            Pedido pedidos = encontrado.get();
            pedidos.setData(alterado.getData());
            pedidos.setDescricao(alterado.getDescricao());
            pedidos.setProduto(alterado.getProduto());
            return repositoryPedido.save(pedidos);
        }
        return null;
    }
    public void remover(Long id) {
        repositoryPedido.deleteById(id);
    }



}


