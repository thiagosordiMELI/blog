package com.blog.blog.dto;

import com.blog.blog.model.EntradaBlog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EntradaBlogDto {
    private int id;
    private String titulo;
    private String nomeAutor;
    private Date dataPublicacao;

    public EntradaBlogDto(EntradaBlog e){
        this.id = e.getId();
        this.titulo = e.getTitulo();
        this.nomeAutor = e.getNomeAutor();
        this.dataPublicacao = e.getDataPublicacao();
    }
}
