package com.blog.blog.repository;

import com.blog.blog.exception.AlreadyExistsException;
import com.blog.blog.exception.NotFoundException;
import com.blog.blog.model.EntradaBlog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EntradaBlogRepository {

    public int createEntradaBlog(EntradaBlog entrada){
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<EntradaBlog> entradas = Arrays.asList(mapper.readValue(new File("src/main/resources/entradas.json"), EntradaBlog[].class));
            entradas = new ArrayList(entradas);
            if(entradas.stream().anyMatch(entradaBlog -> entradaBlog.getId() == entrada.getId())){
                throw new AlreadyExistsException("Entrada Blog com id "+entrada.getId()+" já existe");
            }
            entradas.add(entrada);
            mapper.writeValue(new File("src/main/resources/entradas.json"), entradas);
            return entrada.getId();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<EntradaBlog> getEntradasBlog() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<EntradaBlog> entradas = Arrays.asList(mapper.readValue(new File("src/main/resources/entradas.json"), EntradaBlog[].class));
            entradas = new ArrayList(entradas);
            return entradas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public EntradaBlog get(int id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<EntradaBlog> entradas = Arrays.asList(mapper.readValue(new File("src/main/resources/entradas.json"), EntradaBlog[].class));
            entradas = new ArrayList(entradas);
            for(EntradaBlog e:entradas){
                if(e.getId() == id){
                    return e;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new NotFoundException("Entrada Blog com id "+id+" não foi encontrado.");
    }
}
