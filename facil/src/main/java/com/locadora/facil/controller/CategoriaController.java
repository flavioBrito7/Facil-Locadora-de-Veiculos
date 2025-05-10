package com.locadora.facil.controller;

import com.locadora.facil.model.CategoriaEntity;
import com.locadora.facil.service.CategoriaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/listar-categrorias")
    public ResponseEntity<List> getAllCategorias() {
        List<CategoriaEntity> categorias = categoriaService.listarTodasCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<CategoriaEntity> getCategoriaById(@PathVariable Integer id) {
        CategoriaEntity categoria = categoriaService.getCategoriaId(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<CategoriaEntity> addCategoria(@Valid @RequestBody CategoriaEntity cat) {
        var novaCategoria = categoriaService.criarCategoria(cat);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<CategoriaEntity> atualizarCategoria(@PathVariable Integer id, @RequestBody CategoriaEntity categoria) {
        var categoriaAtualizada = categoriaService.atualizarCategoria(id, categoria);
        return new ResponseEntity<>(categoriaAtualizada, HttpStatus.OK);
    }

    @GetMapping( "/deletar/{id}" )
    public ResponseEntity deletarCategoria( @PathVariable Integer id ) {
        categoriaService.deletarCategoria( id );
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
