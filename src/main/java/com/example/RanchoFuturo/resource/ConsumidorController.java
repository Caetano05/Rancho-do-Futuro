package com.example.RanchoFuturo.resource;

import com.example.RanchoFuturo.model.Consumidor;
import com.example.RanchoFuturo.model.Produto;
import com.example.RanchoFuturo.service.ConsumidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/consumidor")

public class ConsumidorController {
    @Autowired
    private ConsumidorService serviceConsumidor;


    @PostMapping
    public ResponseEntity create(@RequestBody Consumidor entity){
        Consumidor save = serviceConsumidor.salvar(entity);
        return ResponseEntity.created(URI.create("/api/consumidor/" + entity.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<Consumidor> consumidores =serviceConsumidor.buscaTodos();
        return ResponseEntity.ok(consumidores);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Consumidor consumidores = serviceConsumidor.buscaPorId(id);
        return ResponseEntity.ok().body(consumidores);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceConsumidor.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Consumidor entity){
        Consumidor alterado = serviceConsumidor.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
