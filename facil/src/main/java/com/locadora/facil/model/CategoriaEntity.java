package com.locadora.facil.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;
    
@Data
@Entity
@Table( name = "Categorias" )
@Component
public class CategoriaEntity {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String descricao; 
    private Double valor;
    
    @OneToOne( orphanRemoval = true, cascade = CascadeType.PERSIST )
    @PrimaryKeyJoinColumn
    private VeiculoEntity veiculoEntity;
  
}
