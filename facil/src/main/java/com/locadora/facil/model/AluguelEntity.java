package com.locadora.facil.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "Alugueis")
public class AluguelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private ClienteEntity clienteEntity;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    private VeiculoEntity veiculoEntity;

    private LocalDate dataInicio;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private FuncionarioEntity funcionarioEntity;

    private LocalDate dataFim;
    
    private Double valorDiaria;

    private Double total;
    
    private Integer ativo;
    
     public  String getNomeCliente(){
       return this.clienteEntity.getNome();
    }
    
    public  void setNomeCliente(String nomeCliente){
        this.clienteEntity.setNome( nomeCliente );
    }
    
     public  String getNomeFuncionario(){
       return this.funcionarioEntity.getNome();
    }
    
    public  void setNomeFuncionario(String nomeFuncionario){
        this.funcionarioEntity.setNome( nomeFuncionario );
    }
    
    public String getModeloVeiculo() {
        return this.veiculoEntity.getModelo();
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.veiculoEntity.setModelo(modeloVeiculo);
    }
 
}
