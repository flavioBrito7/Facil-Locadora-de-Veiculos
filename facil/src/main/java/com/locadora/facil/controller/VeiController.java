package com.locadora.facil.controller;

import com.locadora.facil.model.CategoriaEntity;
import com.locadora.facil.model.VeiculoEntity;
import com.locadora.facil.service.CategoriaService;
import com.locadora.facil.service.VeiculoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VeiController {
    
    @Autowired
    VeiculoService veiculoService;
    
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/veiculos")
    public String viewHomePage( Model model ) {
        model.addAttribute( "listarVeiculos", veiculoService.listarTodosVeiculos() );
        return "listar-veiculos";
    }
    
    @GetMapping("/listaVeiculosDisponiveis")
    public String viewVeiculosDisponiveis( Model model ) {
        model.addAttribute( "listarVeiculosDisponiveis", veiculoService.listarVeiculosDisponiveis() );
        return "listar-veiculos-disponiveis";
    }

    @GetMapping( "/criarVeiculoForm" )
    public String criarVeiculoForm( Model model ) {
        VeiculoEntity vei = new VeiculoEntity();
        model.addAttribute( "veiculo", vei );
        
         List<CategoriaEntity> listaCategorias = categoriaService.listarTodasCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
        
        return "cadastrar-veiculo";
    }

    @PostMapping( "/salvarVeiculo" )
    public String salvarVeiculo( @Valid @ModelAttribute( "veiculo" ) VeiculoEntity veiculo, BindingResult result ) {

        if ( result.hasErrors() ) {
            
            return "atualizar-veiculo"; 
        }

        if ( veiculo.getId() == null ) {
            
                veiculoService.criarVeiculo( veiculo );   
                
        } else {
            
            veiculoService.atualizarVeiculo( veiculo.getId(), veiculo );
        }

        return "redirect:/veiculos";

    }

    @GetMapping("/atualizarVeiculoForm/{id}")
    public String atualizarVeiculoForm( @PathVariable( value = "id" ) Integer id, Model model ) {

        VeiculoEntity vei = veiculoService.getVeiculoId( id );

        model.addAttribute("veiculo", vei);

        return "atualizar-veiculo";
    }
    
    @GetMapping( "/deletarVeiculo/{id}" )
    public String deletarVeiculo( @PathVariable(value = "id") Integer id ) {
        veiculoService.deletarVeiculo( id );
        return "redirect:/veiculos";
    }
    
}
