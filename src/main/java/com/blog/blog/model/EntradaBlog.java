package com.blog.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nomeAutor;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataPublicacao;
}
