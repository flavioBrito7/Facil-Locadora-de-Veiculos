package com.locadora.facil.service;

import com.locadora.facil.exception.ResourceNotFoundException;
import com.locadora.facil.model.VeiculoEntity;
import com.locadora.facil.model.VeiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    
    @Autowired
    VeiculoRepository veiculoRepository;
    
    public VeiculoEntity criarVeiculo( VeiculoEntity veiculo ) {
        veiculo.setId( null );
        veiculo.setAlugado(0);
        veiculoRepository.save( veiculo );
        return veiculo;
    }
    
    public VeiculoEntity getVeiculoId( Integer veiculoID ) {
        return veiculoRepository.findById( veiculoID ).orElseThrow(() -> new ResourceNotFoundException( "O veículo de código ["+ veiculoID +"] não foi encontrado.") );  
    }
    
    public VeiculoEntity atualizarVeiculo( Integer VeiculoID, VeiculoEntity veiculoRequest ) {
        VeiculoEntity veiculo = getVeiculoId( VeiculoID );
        veiculo.setModelo(veiculoRequest.getModelo());
        veiculo.setMontadora(veiculoRequest.getMontadora());
        veiculo.setCor(veiculoRequest.getCor());
        veiculo.setAno(veiculoRequest.getAno());
        veiculo.setVersao(veiculoRequest.getVersao());
        veiculo.setCategoriaEntity(veiculoRequest.getCategoriaEntity());
        veiculoRepository.save( veiculo );
        return veiculo;
    }
    
    public List<VeiculoEntity> listarTodosVeiculos() {
        return veiculoRepository.findAll();
    }
    
    public List<VeiculoEntity> listarVeiculosDisponiveis() {
        return veiculoRepository.listaVeiculosDisponiveis( 0 );
    }

    public void deletarVeiculo( Integer veiculoID ) {
        VeiculoEntity veiculo= getVeiculoId( veiculoID );
        veiculoRepository.deleteById( veiculo.getId() );
    }

}
