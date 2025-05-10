package com.locadora.facil.service;

import com.locadora.facil.exception.ResourceNotFoundException;
import com.locadora.facil.model.ClienteEntity;
import com.locadora.facil.model.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    public ClienteEntity criarCliente( ClienteEntity cliente ) {
        cliente.setId( null );
        clienteRepository.save( cliente );
        return cliente;
    }
    
    public ClienteEntity getClienteId( Integer clienteID ) {
        return clienteRepository.findById( clienteID ).orElseThrow(() -> new ResourceNotFoundException( "O cliente de código ["+ clienteID +"] não foi encontrado.") );  
    }
    
    public ClienteEntity atualizarCliente( Integer clienteID, ClienteEntity clienteRequest ) {
        ClienteEntity cliente = getClienteId( clienteID );
        cliente.setNome(clienteRequest.getNome());
        cliente.setCpf(clienteRequest.getCpf());
        cliente.setIdentidade(clienteRequest.getIdentidade());
        cliente.setContato(clienteRequest.getContato());
        cliente.setEndereco(clienteRequest.getEndereco());
        cliente.setCnh(clienteRequest.getCnh());
        cliente.setEmail(clienteRequest.getEmail());
        clienteRepository.save( cliente );
        return cliente;
    }
    
    public List<ClienteEntity> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    public void deletarCliente( Integer clienteID ) {
        ClienteEntity cliente = getClienteId( clienteID );
        clienteRepository.deleteById( cliente.getId() );
    }

}
