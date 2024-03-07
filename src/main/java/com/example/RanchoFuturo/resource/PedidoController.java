package com.example.RanchoFuturo.resource;

import com.example.RanchoFuturo.model.Pedido;
import com.example.RanchoFuturo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    @Autowired
    private PedidoService servicePedido;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Pedido pedidos){
        Pedido save = servicePedido.salvar(pedidos);
        return ResponseEntity.created(URI.create("/pedido/" + pedidos.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<Pedido> pedidos = servicePedido.buscaTodos();
        return ResponseEntity.ok(pedidos);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Pedido pedidos = servicePedido.buscaPorId(id);
        return ResponseEntity.ok().body(pedidos);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        servicePedido.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Pedido entity){
        Pedido alterado = servicePedido.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}


