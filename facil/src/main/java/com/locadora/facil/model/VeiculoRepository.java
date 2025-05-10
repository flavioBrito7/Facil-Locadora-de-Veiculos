
package com.locadora.facil.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Integer> {
    
    @Query( value = "select v.id, v.alugado, v.ano, v.cor, v.modelo, v.montadora, v.versao, v.categoria_id from veiculos v where v.alugado = ?1", nativeQuery = true)
        List<VeiculoEntity> listaVeiculosDisponiveis(int StatusVeiculo);

}

