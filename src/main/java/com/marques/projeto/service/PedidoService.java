package com.marques.projeto.service;

import com.marques.projeto.entities.Pedido;
import com.marques.projeto.entities.User;
import com.marques.projeto.repository.PedidoRepository;
import com.marques.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public List<Pedido> findAll(){
        return repository.findAll();
    }
    public Pedido findById(Long id){
        Optional<Pedido> obj = repository.findById(id);
        return obj.get();
    }
}
