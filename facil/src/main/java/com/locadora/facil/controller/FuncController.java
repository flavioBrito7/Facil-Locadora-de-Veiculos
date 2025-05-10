
package com.locadora.facil.controller;

import com.locadora.facil.model.FuncionarioEntity;
import com.locadora.facil.service.FuncionarioService;
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
public class FuncController {
    
    @Autowired
    FuncionarioService funcionarioService;
    
    @GetMapping("/funcionarios")
    public String viewHomePage( Model model ) {
        model.addAttribute( "listarFuncionarios", funcionarioService.listarTodosFuncionarios() );
        return "listar-funcionarios";
    }

    @GetMapping( "/criarFuncionarioForm" )
    public String criarFuncionarioForm( Model model ) {
        FuncionarioEntity func = new FuncionarioEntity();
        model.addAttribute( "funcionario", func );
        return "cadastrar-funcionario";
    }

    @PostMapping( "/salvarFuncionario" )
    public String salvarFuncionario( @Valid @ModelAttribute( "funcionario" ) FuncionarioEntity func, BindingResult result ) {

        if ( result.hasErrors() ) {
            
            return "cadastrar-funcionario"; 

        }

        if ( func.getId() == null ) {
            
                funcionarioService.criarFuncionario( func );   
                
        } else {
            
            funcionarioService.atualizarFuncionario( func.getId(), func );
        }

        return "redirect:/funcionarios";

    }

    @GetMapping("/atualizarFuncionarioForm/{id}")
    public String atualizarFuncionarioForm( @PathVariable( value = "id" ) Integer id, Model model ) {

        FuncionarioEntity func = funcionarioService.getFuncionarioId( id );

        model.addAttribute("funcionario", func);

        return "atualizar-funcionario";
    }
    
    @GetMapping( "/deletarFuncionario/{id}" )
    public String deletarFuncionario( @PathVariable(value = "id") Integer id ) {
        funcionarioService.deletarFuncionario( id );
        return "redirect:/funcionarios";
    }
    
}
