package com.paulovictor.cursomc.resources;

import com.paulovictor.cursomc.domain.Cliente;
import com.paulovictor.cursomc.domain.Pedido;
import com.paulovictor.cursomc.services.ClienteService;
import com.paulovictor.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Pedido obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}
