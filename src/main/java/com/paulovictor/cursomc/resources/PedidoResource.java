package com.paulovictor.cursomc.resources;

import com.paulovictor.cursomc.domain.Categoria;
import com.paulovictor.cursomc.domain.Cliente;
import com.paulovictor.cursomc.domain.Pedido;
import com.paulovictor.cursomc.dto.CategoriaDTO;
import com.paulovictor.cursomc.services.ClienteService;
import com.paulovictor.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> find(@PathVariable Integer id) {

        Pedido obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping()
    public ResponseEntity<Page<Pedido>> findPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                       @RequestParam(name = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                       @RequestParam(name = "orderBy", defaultValue = "instante") String orderBy,
                                                       @RequestParam(name = "direction", defaultValue = "DESC") String direction) {

        Page<Pedido> list = service.findPage(page, linesPerPage, orderBy, direction);

        return ResponseEntity.ok().body(list);
    }
}
