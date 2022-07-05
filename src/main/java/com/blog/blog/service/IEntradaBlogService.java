package com.blog.blog.service;

import com.blog.blog.dto.EntradaBlogDto;
import com.blog.blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService {

    public int createEntradaBlog(EntradaBlog entrada);

    public List<EntradaBlogDto> getEntradasBlog();
    public EntradaBlogDto get(int id);
}
