package com.example.RanchoFuturo.service;

import com.example.RanchoFuturo.model.Produto;

import com.example.RanchoFuturo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repositoryProduto;
    public Produto salvar(Produto entity) { return repositoryProduto.save(entity);}

    public List<Produto> buscaTodos() {return  repositoryProduto.findAll();}

    public Produto buscaPorId(Long id){
        return  repositoryProduto.findById(id).orElse(null);
    }
    public Produto alterar(Long id, Produto alterado) {
        Optional<Produto> encontrado = repositoryProduto.findById(id);
        if(encontrado.isPresent()){

            Produto produto = encontrado.get();
          produto.setNome(alterado.getNome());
          produto.setDescricao(alterado.getDescricao());
          produto.setQuantidade(alterado.getQuantidade());
          produto.setValor(alterado.getValor());
        }
        return null;
    }
    public void remover(Long id) {
        repositoryProduto.deleteById(id);
    }

}
