package com.locadora.facil.controller;

import com.locadora.facil.model.AluguelEntity;
import com.locadora.facil.service.AluguelService;
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

@RequestMapping( "/alugueis" )
public class AluguelController {
    
    @Autowired
   AluguelService  aluguelService;
    
    @GetMapping("/listar-alugueis")
    public ResponseEntity<List> getAllClientes() {      
         List<AluguelEntity> alugueis = aluguelService.listarTodosAlugueis();
        return new ResponseEntity<>( alugueis, HttpStatus.OK );
    }
    
    @GetMapping("/listar-alugueis-pendentes")
    public ResponseEntity<List> getAllAlugueisPendentes() {      
         List<AluguelEntity> alugueisPendentes = aluguelService.listarAlugueisAtivos();
        return new ResponseEntity<>( alugueisPendentes, HttpStatus.OK );
    }
    
     @GetMapping("/listar-alugueis-encerrados")
    public ResponseEntity<List> getAllAlugueisEncerrados() {      
         List<AluguelEntity> alugueisEncerrados = aluguelService.listarAlugueisEncerrados();
        return new ResponseEntity<>( alugueisEncerrados, HttpStatus.OK );
    }
    
    @GetMapping( "/pesquisar/{id}" )
    public ResponseEntity<AluguelEntity> getAluguelById( @PathVariable Integer id ) {
        AluguelEntity aluguel = aluguelService.getAluguelID( id );
        return new ResponseEntity<>( aluguel, HttpStatus.OK );
    }
    
    @PostMapping("/adicionar")
      public ResponseEntity<AluguelEntity> addAluguel( @Valid @RequestBody AluguelEntity alu ) {
        var novoAluguel = aluguelService.criarAluguel( alu );
        return new ResponseEntity<>( novoAluguel, HttpStatus.CREATED );
    }
      
    @PutMapping( "/encerrar/{id}" )
    public ResponseEntity<AluguelEntity> encerrarAluguel( @PathVariable Integer id, @RequestBody AluguelEntity aluguel ) {
        var aluguelAtualizado = aluguelService.encerrarAluguel( id, aluguel );
        return new ResponseEntity<>( aluguelAtualizado, HttpStatus.OK );
    }
    
    @DeleteMapping( "/deletar/{id}" )
    public ResponseEntity deletarAluguel( @PathVariable Integer id ) {
        aluguelService.deletarAluguel( id );
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
