package com.locadora.facil.service;

import com.locadora.facil.exception.ResourceNotFoundException;
import com.locadora.facil.model.AluguelEntity;
import com.locadora.facil.model.AluguelRepository;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {

    @Autowired
    AluguelRepository aluguelRepository;

    public AluguelEntity criarAluguel( AluguelEntity aluguel ) {
        
        aluguel.getVeiculoEntity().setAlugado( 1 );
        
        double valorDiaria = aluguel.getVeiculoEntity().getCategoriaEntity().getValor();
        aluguel.setValorDiaria(valorDiaria);       
        
        aluguel.setId( null );
        
        aluguel.setAtivo( 1 );
        
        aluguelRepository.save( aluguel );
        
        return aluguel;
    }

    public AluguelEntity getAluguelID(Integer aluguelID) {
        return aluguelRepository.findById(aluguelID).orElseThrow(() -> new ResourceNotFoundException("O aluguel de código [" + aluguelID + "] não foi encontrado."));
    }

    public AluguelEntity encerrarAluguel(Integer aluguelID, AluguelEntity aluguelRequest) {
        AluguelEntity aluguel = getAluguelID(aluguelID);
        
        aluguel.setDataFim(aluguelRequest.getDataFim());
        
        // Colhendo a data de início do aluguel e atribuindo à variável "dataDaRetirada"
        LocalDate dataDaRetirada = aluguel.getDataInicio();
        // Colhendo a data final do aluguel e atribuindo à variável "dataDoRetorno"
        LocalDate dataDoRetorno = aluguel.getDataFim();      
        // Atribuindo o resultado da função "diferencaDatas" à variável "qteDias"
        int qtdeDias = this.diferencaDatas( dataDaRetirada, dataDoRetorno );      
        // Atribuindo o valor unitário da diária à variável "valorDaDiaria"
        Double valorDaDiaria = aluguel.getVeiculoEntity().getCategoriaEntity().getValor();       
        // Atribuindo o resultado da função "calculaTotal" à variável "vlrTotalDaLocacao"
        Double vlrTotalDaLocacao = this.calculaTotal( valorDaDiaria, qtdeDias );
        // Atribuindo o resultado à variável total
        aluguel.setTotal( vlrTotalDaLocacao );
         // Alterando o status alugado do veículo de (1) para  (0), disponível
        aluguel.getVeiculoEntity().setAlugado(0);
        // Alterando o status do aluguel de ativo (1) para encerrado (0)
        aluguel.setAtivo(0);

        aluguelRepository.save( aluguel );

        return aluguel;
    }

    // Função para calcular a diferença em dias entre a data de retiraída e data de retorno do veículo alugado
    public Integer diferencaDatas(LocalDate data1, LocalDate data2) {
        Period diferenca = Period.between( data1, data2 );
        int dias = diferenca.getDays();

        if ( dias == 0 ) {           
            return dias + 1;
        } else {
            return dias;
        }
    }
    
    // Função para calcular o valor total do aluguel considerando a quantidade de dias de locação e o valor da diária
    public Double calculaTotal( double vlrDiaria, int qtdeDias ) {
        return vlrDiaria * qtdeDias;
    }

    public List<AluguelEntity> listarTodosAlugueis() {
        return aluguelRepository.findAll();
    }
   
    public List<AluguelEntity> listarAlugueisAtivos() {
        return aluguelRepository.listarAlugueisAtivos();
    }
    
    public List<AluguelEntity> listarAlugueisEncerrados() {
        return aluguelRepository.listarAlugueisEncerrados();
    }
    
    public void deletarAluguel( Integer aluguelID ) {
        AluguelEntity aluguel = getAluguelID( aluguelID );
        aluguelRepository.deleteById( aluguel.getId() );
    }

}
