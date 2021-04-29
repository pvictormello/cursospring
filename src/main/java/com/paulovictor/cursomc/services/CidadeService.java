package com.paulovictor.cursomc.services;

import com.paulovictor.cursomc.domain.Cidade;
import com.paulovictor.cursomc.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll(Integer estadoId){
        return cidadeRepository.findCidades(estadoId);
    }

}
