package com.locadora.facil.controller;

import com.locadora.facil.model.AluguelEntity;
import com.locadora.facil.model.ClienteEntity;
import com.locadora.facil.model.FuncionarioEntity;
import com.locadora.facil.model.VeiculoEntity;
import com.locadora.facil.service.AluguelService;
import com.locadora.facil.service.ClienteService;
import com.locadora.facil.service.FuncionarioService;
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
public class AluController {
    
    @Autowired
    AluguelService aluguelService;
    
    @Autowired
    ClienteService clienteService;
    
    @Autowired
    VeiculoService veiculoService;
    
     @Autowired
    FuncionarioService funcionarioService;
    
    @GetMapping("/alugueis")
    public String viewHomePage( Model model ) {
        model.addAttribute( "listarAlugueis", aluguelService.listarTodosAlugueis() );
        return "listar-alugueis";
    }
    
    @GetMapping("/alugueisAtivos")
    public String viewAlugueisPendentes( Model model ) {
        model.addAttribute( "listarAlugueisPendentes", aluguelService.listarAlugueisAtivos() );
        return "listar-alugueis-pendentes";
    }
    
     @GetMapping("/alugueisEncerrados")
    public String viewAlugueisEncerrados( Model model ) {
        model.addAttribute( "listarAlugueisEncerrados", aluguelService.listarAlugueisEncerrados() );
        return "listar-alugueis-encerrados";
    }

    @GetMapping( "/criarAluguelForm" )
    public String criarAluguelForm( Model model ) {
        AluguelEntity aluguel = new AluguelEntity();
        model.addAttribute( "aluguel", aluguel );

        List<ClienteEntity> listaClientes = clienteService.listarTodosClientes();
        model.addAttribute("listaClientes", listaClientes);
        
        List<VeiculoEntity> listaVeiculosDisponiveis = veiculoService.listarVeiculosDisponiveis();
        model.addAttribute("listaVeiculosDisponiveis", listaVeiculosDisponiveis);
        
        List<FuncionarioEntity> listaFuncionarios = funcionarioService.listarTodosFuncionarios();
        model.addAttribute("listaFuncionarios", listaFuncionarios);
        
        return "cadastrar-aluguel";
    }

    @PostMapping( "/salvarAluguel" )
    public String salvarAluguel( @Valid @ModelAttribute( "aluguel" ) AluguelEntity alulguel, BindingResult result ) {

        if ( result.hasErrors() ) {
            
            return "cadastrar-aluguel"; 
        }

        if ( alulguel.getId() == null ) {
            
                aluguelService.criarAluguel( alulguel );   
                
        } else {
            
            aluguelService.encerrarAluguel( alulguel.getId(), alulguel );
        }

        return "redirect:/alugueisAtivos";

    }
    
    @PostMapping( "/encerrarAluguel" )
    public String encerrarAluguel( @Valid @ModelAttribute( "aluguel" ) AluguelEntity alulguel, BindingResult result ) {

        if ( result.hasErrors() ) {
            
            return "encerrar-aluguel"; 
        }

        if ( alulguel.getId() != null ) {
            
                aluguelService.encerrarAluguel( alulguel.getId(), alulguel );   
                
        } 
        
        return "redirect:/alugueis";

    }

    @GetMapping("/encerrarAluguelForm/{id}")
    public String encerrarAluguelForm( @PathVariable( value = "id" ) Integer id, Model model ) {

        AluguelEntity aluguel = aluguelService.getAluguelID( id );
        model.addAttribute("aluguel", aluguel);

        return "encerrar-aluguel";
    }
    
    
    @GetMapping( "/deletarAluguel/{id}" )
    public String deletarAluguel( @PathVariable(value = "id") Integer id ) {
        aluguelService.deletarAluguel( id );
        return "redirect:/alugueis";
    }
    
}
