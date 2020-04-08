package com.paulovictor.cursomc.resources;

import com.paulovictor.cursomc.domain.Categoria;
import com.paulovictor.cursomc.domain.Produto;
import com.paulovictor.cursomc.dto.ProdutoDTO;
import com.paulovictor.cursomc.dto.CategoriaDTO;
import com.paulovictor.cursomc.resources.utils.URL;
import com.paulovictor.cursomc.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> find(@PathVariable Integer id) {

        Produto obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping()
    public ResponseEntity<Page<ProdutoDTO>> findPage(@RequestParam(name = "nome", defaultValue = "") String nome,
                                                     @RequestParam(name = "categorias", defaultValue = "0") String categorias,
                                                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                     @RequestParam(name = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                     @RequestParam(name = "orderBy", defaultValue = "nome") String orderBy,
                                                     @RequestParam(name = "direction", defaultValue = "ASC") String direction) {
        String nomeDecoded = URL.decodeParam(nome);
        List<Integer> ids = URL.decodeIntList(categorias);
        Page<Produto> list = service.search(nome, ids, page, linesPerPage, orderBy, direction);
        Page<ProdutoDTO> listDTO = list.map(obj -> new ProdutoDTO(obj));

        return ResponseEntity.ok().body(listDTO);
    }

}
