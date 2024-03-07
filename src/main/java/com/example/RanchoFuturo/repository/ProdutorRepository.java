package com.example.RanchoFuturo.repository;

import com.example.RanchoFuturo.model.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Long> {

    public Produtor findByCnpj(String cnpj);
}
