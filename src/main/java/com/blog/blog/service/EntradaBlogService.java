package com.blog.blog.service;

import com.blog.blog.dto.EntradaBlogDto;
import com.blog.blog.model.EntradaBlog;
import com.blog.blog.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService implements IEntradaBlogService {

    @Autowired
    private EntradaBlogRepository repo;

    public int createEntradaBlog(EntradaBlog entrada){
        return repo.createEntradaBlog(entrada);
    }


    public List<EntradaBlogDto> getEntradasBlog() {
        return repo.getEntradasBlog().stream().map(entradaBlog -> new EntradaBlogDto(entradaBlog)).collect(Collectors.toList());
    }

    public EntradaBlogDto get(int id) {
        return new EntradaBlogDto(repo.get(id));
    }
}
