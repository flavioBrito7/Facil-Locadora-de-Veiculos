
package com.locadora.facil.controller;

import com.locadora.facil.model.ClienteEntity;
import com.locadora.facil.service.ClienteService;
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
public class CliController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/clientes")
    public String viewHomePage( Model model ) {
        model.addAttribute( "listarClientes", clienteService.listarTodosClientes() );
        return "listar-clientes";
    }

    @GetMapping( "/criarClienteForm" )
    public String criarClienteForm( Model model ) {
        ClienteEntity cli = new ClienteEntity();
        model.addAttribute( "cliente", cli );
        return "cadastrar-cliente";
    }

    @PostMapping( "/salvarCliente" )
    public String salvarCliente( @Valid @ModelAttribute( "cliente" ) ClienteEntity cli, BindingResult result ) {

        if ( result.hasErrors() ) {
            
            return "cadastrar-cliente"; 
        }

        if ( cli.getId() == null ) {
            
                clienteService.criarCliente( cli );   
                
        } else {
            
            clienteService.atualizarCliente( cli.getId(), cli );
        }

        return "redirect:/clientes";

    }

    @GetMapping("/atualizarClienteForm/{id}")
    public String atualizarClienteForm( @PathVariable( value = "id" ) Integer id, Model model ) {

        ClienteEntity cli = clienteService.getClienteId( id );

        model.addAttribute("cliente", cli);

        return "atualizar-cliente";
    }
    
    @GetMapping( "/deletarCliente/{id}" )
    public String deletarCliente( @PathVariable(value = "id") Integer id ) {
        clienteService.deletarCliente( id );
        return "redirect:/clientes";
    }
    
}
