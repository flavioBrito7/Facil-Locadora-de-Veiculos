
package com.locadora.facil.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<AluguelEntity, Integer> {
        
       @Query( value = "select * from alugueis where alugueis.ativo = 1", nativeQuery = true)
        List<AluguelEntity> listarAlugueisAtivos();
        
          @Query( value = "select * from alugueis where alugueis.ativo = 0", nativeQuery = true)
        List<AluguelEntity> listarAlugueisEncerrados();

              
}

