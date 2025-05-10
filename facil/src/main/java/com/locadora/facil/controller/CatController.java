
package com.locadora.facil.controller;

import com.locadora.facil.model.CategoriaEntity;
import com.locadora.facil.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CatController {
    
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/categorias")
    public String viewHomePage( Model model ) {
        model.addAttribute( "listarCategorias", categoriaService.listarTodasCategorias() );
        return "listar-categorias";
    }

    @GetMapping( "/criarCategoriaForm" )
    public String criarCategoriaForm( Model model ) {
        CategoriaEntity cat = new CategoriaEntity();
        model.addAttribute( "categoria", cat );
        return "cadastrar-categoria";
    }

    @PostMapping( "/salvarCategoria" )
    public String salvarCategoria( @Valid @ModelAttribute( "categoria" ) CategoriaEntity cat, BindingResult result ) {

        if ( result.hasErrors() ) {
            
            return "cadastrar-categoria"; 
        }

        if ( cat.getId() == null ) {
            
                categoriaService.criarCategoria( cat );   
                
        } else {
            
            categoriaService.atualizarCategoria( cat.getId(), cat );
        }

        return "redirect:/categorias";

    }

    @GetMapping("/atualizarCategoriaForm/{id}")
    public String atualizarCategoriaForm( @PathVariable( value = "id" ) Integer id, Model model ) {

        CategoriaEntity cat = categoriaService.getCategoriaId( id );

        model.addAttribute("categoria", cat);

        return "atualizar-categoria";
    }
    
    @GetMapping( "/deletarCategoria/{id}" )
    public String deletarCategoria( @PathVariable(value = "id") Integer id ) {
        categoriaService.deletarCategoria( id );
        return "redirect:/categorias";
    }
    
}
