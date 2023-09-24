package com.marques.projeto.service;

import com.marques.projeto.entities.Categoria;
import com.marques.projeto.entities.PedidoItem;
import com.marques.projeto.entities.pk.PedidoItemPK;
import com.marques.projeto.repository.PedidoItemRepository;
import com.marques.projeto.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PedidoItemService {

    @Autowired
    private PedidoItemRepository repository;

    public List<PedidoItem> findAll(){
        return repository.findAll();
    }
    public PedidoItem findById(PedidoItemPK id){
        Optional<PedidoItem> obj = repository.findById(id);
        return obj.get();
    }
}
