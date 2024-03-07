package com.example.RanchoFuturo.resource;

import com.example.RanchoFuturo.model.Produto;
import com.example.RanchoFuturo.model.Produtor;
import com.example.RanchoFuturo.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService serviceProduto;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Produto produto){
        Produto save = serviceProduto.salvar(produto);
        return ResponseEntity.created(URI.create("/produto/" + produto.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<Produto> produtos = serviceProduto.buscaTodos();
        return ResponseEntity.ok(produtos);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Produto produtos = serviceProduto.buscaPorId(id);
        return ResponseEntity.ok().body(produtos);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceProduto.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Produto entity){
        Produto alterado = serviceProduto.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}


