package com.locadora.facil.controller;

import com.locadora.facil.model.ClienteEntity;
import com.locadora.facil.service.ClienteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping( "/clientes" )
public class ClienteController {
    
    @Autowired
   ClienteService  clienteService;
    
    @GetMapping("/listar-clientes")
    public ResponseEntity<List> getAllClientes() {      
         List<ClienteEntity> clientes = clienteService.listarTodosClientes();
        return new ResponseEntity<>( clientes, HttpStatus.OK );
    }
    
    @GetMapping( "/pesquisar/{id}" )
    public ResponseEntity<ClienteEntity> getClienteById( @PathVariable Integer id ) {
        ClienteEntity cliente = clienteService.getClienteId( id );
        return new ResponseEntity<>( cliente, HttpStatus.OK );
    }
    
    @PostMapping("/adicionar")
      public ResponseEntity<ClienteEntity> addCliente( @Valid @RequestBody ClienteEntity cli ) {
        var novoCliente = clienteService.criarCliente( cli );
        return new ResponseEntity<>( novoCliente, HttpStatus.CREATED );
    }
      
    @PutMapping( "/atualizar/{id}" )
    public ResponseEntity<ClienteEntity> atualizarCliente( @PathVariable Integer id, @RequestBody ClienteEntity cliente ) {
        var clienteAtualizado = clienteService.atualizarCliente( id, cliente );
        return new ResponseEntity<>( clienteAtualizado, HttpStatus.OK );
    }
    
    @DeleteMapping( "/deletar/{id}" )
    public ResponseEntity deletarCliente( @PathVariable Integer id ) {
        clienteService.deletarCliente( id );
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
