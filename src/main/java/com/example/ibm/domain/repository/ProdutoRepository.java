package com.example.ibm.domain.repository;

import com.example.ibm.domain.entity.Cliente;
import com.example.ibm.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByCodigoDeBarras(String codigoDeBarras);


}
