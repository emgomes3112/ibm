package com.example.ibm.domain.repository;

import com.example.ibm.domain.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {


}
