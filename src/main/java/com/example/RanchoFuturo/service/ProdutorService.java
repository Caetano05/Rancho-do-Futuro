package com.example.RanchoFuturo.service;

import com.example.RanchoFuturo.model.Produtor;
import com.example.RanchoFuturo.repository.ProdutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutorService {
    @Autowired
    private ProdutorRepository repository;
    public Produtor salvar(Produtor entity) throws Exception {
        if (repository.findByCnpj(entity.getCnpj()) != null){
            throw new Exception("Cpf ja cadastrado");
        }

        return repository.save(entity);
    }

    public List<Produtor> buscaTodos() {return  repository.findAll();}

    public Produtor buscaPorId(Long id){
        return  repository.findById(id).orElse(null);
    }
    public Produtor alterar(Long id, Produtor alterado) {
        Optional<Produtor> encontrado = repository.findById(id);
        if(encontrado.isPresent()){
            Produtor produtor = encontrado.get();
            produtor.setNome(alterado.getNome());
            produtor.setTelefone(alterado.getTelefone());
            produtor.setRazaoSocial(alterado.getRazaoSocial());
            return repository.save(produtor);
        }
        return null;
    }
    public void remover(Long id) {
        repository.deleteById(id);
    }

}
