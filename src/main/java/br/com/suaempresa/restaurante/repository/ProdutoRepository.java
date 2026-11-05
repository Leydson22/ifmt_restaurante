package br.com.suaempresa.restaurante.repository;

import br.com.suaempresa.restaurante.dto.ProdutoDTO;
import br.com.suaempresa.restaurante.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContaining(String nome);
    List<Produto> findByPrecoBetween(Double precoMinimo, Double
            precoMaximo);

}


