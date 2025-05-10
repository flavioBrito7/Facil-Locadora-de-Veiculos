
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
    
@Data
@Entity
@Table( name = "Clientes" )
public class ClienteEntity {
   
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;  
    private String nome;
    private String cpf;
    private String identidade;
    private String contato;
    private String endereco;
    private String cnh;
    private String email;
      
    @OneToOne( orphanRemoval = true, cascade = CascadeType.PERSIST )
    @PrimaryKeyJoinColumn
    private AluguelEntity aluguel = new AluguelEntity();
  
}
