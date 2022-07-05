package com.blog.blog.controller;

import com.blog.blog.dto.EntradaBlogDto;
import com.blog.blog.model.EntradaBlog;
import com.blog.blog.service.EntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class EntradaBlogController {

    @Autowired
    private EntradaBlogService service;

    @PostMapping
    public ResponseEntity<Integer> createVehicle(@RequestBody EntradaBlog entrada){
        return new ResponseEntity(service.createEntradaBlog(entrada), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EntradaBlog>> listEntradasBlog(){
        List<EntradaBlogDto> entradas = service.getEntradasBlog();
        return new ResponseEntity(entradas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDto> getEntradaBlog(@PathVariable int id){
        EntradaBlogDto entrada = service.get(id);
        return new ResponseEntity(entrada, HttpStatus.OK);
    }

}
