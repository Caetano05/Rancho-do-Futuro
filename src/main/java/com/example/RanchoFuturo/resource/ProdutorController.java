package com.example.RanchoFuturo.resource;

import com.example.RanchoFuturo.model.Produtor;
import com.example.RanchoFuturo.service.ProdutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/produtor")
public class ProdutorController {


    @Autowired
    private ProdutorService serviceProdutor;

    @PostMapping()
    public ResponseEntity salvar(@RequestBody Produtor produtor) throws Exception {
        Produtor save = serviceProdutor.salvar(produtor);
        return ResponseEntity.created(URI.create("/produtor/" + produtor.getId())).body(save);
    }

    @GetMapping
    public  ResponseEntity findAll(){
        List<Produtor> produtores = serviceProdutor.buscaTodos();
        return ResponseEntity.ok(produtores);
    }
    @GetMapping("/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){
        Produtor produtor = serviceProdutor.buscaPorId(id);
        return ResponseEntity.ok().body(produtor);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity remove(@PathVariable("id") Long id){
        serviceProdutor.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public  ResponseEntity update(@PathVariable("id") Long id, @RequestBody Produtor entity){
        Produtor alterado = serviceProdutor.alterar(id, entity);
        return  ResponseEntity.ok().body(alterado);
    }
}
