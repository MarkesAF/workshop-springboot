package com.marques.projeto.repository;

import com.marques.projeto.entities.PedidoItem;
import com.marques.projeto.entities.pk.PedidoItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, PedidoItemPK> {
}
