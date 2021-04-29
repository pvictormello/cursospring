package com.paulovictor.cursomc.resources;

import com.paulovictor.cursomc.domain.Cidade;
import com.paulovictor.cursomc.domain.Estado;
import com.paulovictor.cursomc.dto.CidadeDTO;
import com.paulovictor.cursomc.dto.EstadoDTO;
import com.paulovictor.cursomc.services.CidadeService;
import com.paulovictor.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;
    @Autowired
    private CidadeService cidadeService;


    @GetMapping
    public ResponseEntity<List<EstadoDTO>> findAll(){
        List<Estado> estados = estadoService.findAll();
        List<EstadoDTO> estadosDTO = estados.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(estadosDTO);
    }

    @GetMapping(value = "/{estadoId}/cidades")
    public ResponseEntity<List<CidadeDTO>> findAllCidades(@PathVariable Integer estadoId){
        List<Cidade> cidades = cidadeService.findAll(estadoId);
        List<CidadeDTO> cidadesDTO = cidades.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(cidadesDTO);
    }
}
