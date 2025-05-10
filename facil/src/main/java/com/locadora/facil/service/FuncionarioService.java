package com.locadora.facil.service;

import com.locadora.facil.exception.ResourceNotFoundException;
import com.locadora.facil.model.FuncionarioEntity;
import com.locadora.facil.model.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    
    @Autowired
    FuncionarioRepository funcionarioRepository;
    
    public FuncionarioEntity criarFuncionario( FuncionarioEntity funcionario ) {
        funcionario.setId( null );
        funcionarioRepository.save( funcionario );
        return funcionario;
    }
    
    public FuncionarioEntity getFuncionarioId( Integer funcionarioID ) {
        return funcionarioRepository.findById( funcionarioID ).orElseThrow(() -> new ResourceNotFoundException( "O filme de código ["+ funcionarioID +"] não foi encontrado.") );  
    }
    
    public FuncionarioEntity atualizarFuncionario( Integer funcionarioID, FuncionarioEntity funcionarioRequest ) {
        FuncionarioEntity funcionario = getFuncionarioId( funcionarioID );
        funcionario.setNome( funcionarioRequest.getNome() );
        funcionario.setCpf( funcionarioRequest.getCpf() );
        funcionario.setIdentidade( funcionarioRequest.getIdentidade() );
        funcionario.setContato( funcionarioRequest.getContato() );
        funcionario.setEndereco( funcionarioRequest.getEndereco() );
         funcionario.setCargo( funcionarioRequest.getCargo() );
        funcionarioRepository.save( funcionario );
        return funcionario;
    }
    
    public List<FuncionarioEntity> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public void deletarFuncionario( Integer funcionarioID ) {
        FuncionarioEntity funcionario = getFuncionarioId( funcionarioID );
        funcionarioRepository.deleteById( funcionario.getId() );
    }
    
}
