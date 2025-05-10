package com.locadora.facil.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table( name = "Veiculos" )
@Component
public class VeiculoEntity {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id; 
    private String modelo;
    private String montadora;
    private String cor;
    private Integer ano;
    private String versao;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaEntity categoriaEntity;
    
    @OneToOne( orphanRemoval = true, cascade = CascadeType.PERSIST )
    @PrimaryKeyJoinColumn
    private AluguelEntity aluguel = new AluguelEntity();
 
    private Integer alugado;

    public String getModelo() {
        return this.modelo;
    }
  
    public void setModelo(String modeloVeiculo) {
        this.modelo = modeloVeiculo;
    }
   
}
