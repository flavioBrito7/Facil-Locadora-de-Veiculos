package com.locadora.facil.controller;

import com.locadora.facil.model.VeiculoEntity;
import com.locadora.facil.service.VeiculoService;
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

@RequestMapping( "/veiculos" )
public class VeiculoController {
    
    @Autowired
    VeiculoService  veiculoService;
    
    @GetMapping("/listar-veiculos")
    public ResponseEntity<List> getAllVeiculos() {      
         List<VeiculoEntity> veiculos = veiculoService.listarTodosVeiculos();
        return new ResponseEntity<>( veiculos, HttpStatus.OK );
    }
    
    @GetMapping("/listar-veiculos-disponiveis")
    public ResponseEntity<List> getVeiculosDisponiveis() {      
         List<VeiculoEntity> veiculosDisponiveis = veiculoService.listarVeiculosDisponiveis();
        return new ResponseEntity<>( veiculosDisponiveis, HttpStatus.OK );
    }
    
    @GetMapping( "/pesquisar/{id}" )
    public ResponseEntity<VeiculoEntity> getVeiculoById( @PathVariable Integer id ) {
        VeiculoEntity veiculo = veiculoService.getVeiculoId( id );
        return new ResponseEntity<>( veiculo, HttpStatus.OK );
    }
    
    @PostMapping("/adicionar")
      public ResponseEntity<VeiculoEntity> addFuncionario( @Valid @RequestBody VeiculoEntity vei ) {
        var novoVeiculo = veiculoService.criarVeiculo( vei );
        return new ResponseEntity<>( novoVeiculo, HttpStatus.CREATED );
    }
      
    @PutMapping( "/atualizar/{id}" )
    public ResponseEntity<VeiculoEntity> atualizarVeiculo( @PathVariable Integer id, @RequestBody VeiculoEntity veiculo ) {
        var veiculoAtualizado = veiculoService.atualizarVeiculo( id, veiculo );
        return new ResponseEntity<>( veiculoAtualizado, HttpStatus.OK );
    }
    
    @DeleteMapping( "/deletar/{id}" )
    public ResponseEntity deletarVeiculo( @PathVariable Integer id ) {
        veiculoService.deletarVeiculo( id );
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
