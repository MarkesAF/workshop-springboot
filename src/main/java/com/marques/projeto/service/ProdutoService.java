package com.marques.projeto.service;

import com.marques.projeto.entities.Categoria;
import com.marques.projeto.entities.Produto;
import com.marques.projeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }
    public Produto findById(Long id){
        Optional<Produto> obj = repository.findById(id);
        return obj.get();
    }
}
