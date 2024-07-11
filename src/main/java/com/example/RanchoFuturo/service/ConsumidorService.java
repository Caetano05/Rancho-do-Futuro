package com.example.RanchoFuturo.service;

import com.example.RanchoFuturo.model.Consumidor;
import com.example.RanchoFuturo.repository.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumidorService {
    @Autowired
    private ConsumidorRepository repositoryConsumidor;

    public Consumidor salvar(Consumidor entity) { return repositoryConsumidor.save(entity);
    }

    public List<Consumidor> buscaTodos() {
        return repositoryConsumidor.findAll();
    }

    public Consumidor buscaPorId(Long id) {
        return repositoryConsumidor.findById(id).orElse(null);
    }

    public Consumidor alterar(Long id, Consumidor alterado) {
        Optional<Consumidor> encontrado = repositoryConsumidor.findById(id);
        if (encontrado.isPresent()) {
            Consumidor consumidor = encontrado.get();
            consumidor.setNome(alterado.getNome());
            consumidor.setTelefone(alterado.getTelefone());
            return repositoryConsumidor.save(consumidor);
        }

        return null;
    }

    public void remover(Long id) {
        repositoryConsumidor.deleteById(id);


    }
}