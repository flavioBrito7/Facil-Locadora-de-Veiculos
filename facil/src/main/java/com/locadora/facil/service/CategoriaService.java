package com.locadora.facil.service;

import com.locadora.facil.exception.ResourceNotFoundException;
import com.locadora.facil.model.CategoriaEntity;
import com.locadora.facil.model.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    CategoriaRepository categoriaRepository;
    
    public CategoriaEntity criarCategoria( CategoriaEntity categoria ) {
        categoria.setId( null );
        categoriaRepository.save( categoria );
        return categoria;
    }
    
    public CategoriaEntity getCategoriaId( Integer categoriaID ) {
        return categoriaRepository.findById( categoriaID ).orElseThrow(() -> new ResourceNotFoundException( "A categoria de código ["+ categoriaID +"] não foi encontrada.") );  
    }
    
    public CategoriaEntity atualizarCategoria(Integer categoriaID, CategoriaEntity veiculoRequest) {
        CategoriaEntity categoria = getCategoriaId( categoriaID );
        categoria.setDescricao(veiculoRequest.getDescricao());
        categoria.setValor(veiculoRequest.getValor());
        
        categoriaRepository.save(categoria);
        return categoria;
    }
    
    public List<CategoriaEntity> listarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    public void deletarCategoria( Integer categoriaID ) {
        categoriaRepository.deleteById( categoriaID );
    }

}
