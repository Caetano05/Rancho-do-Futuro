package com.example.RanchoFuturo.repository;

import com.example.RanchoFuturo.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
