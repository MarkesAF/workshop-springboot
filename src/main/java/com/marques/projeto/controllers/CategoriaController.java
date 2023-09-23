package com.marques.projeto.controllers;


import com.marques.projeto.entities.Categoria;
import com.marques.projeto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria>findById(@PathVariable Long id){
        Categoria obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
