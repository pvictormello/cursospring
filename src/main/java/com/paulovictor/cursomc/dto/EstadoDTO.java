package com.paulovictor.cursomc.dto;

import com.paulovictor.cursomc.domain.Estado;

public class EstadoDTO {

    private Integer id;
    private String nome;

    public EstadoDTO() {
    }

    public EstadoDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EstadoDTO(Estado estado){
        this.id = estado.getId();
        this.nome = estado.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
