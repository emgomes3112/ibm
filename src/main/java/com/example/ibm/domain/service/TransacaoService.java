package com.example.ibm.domain.service;

import com.example.ibm.domain.entity.Transacao;
import com.example.ibm.domain.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TransacaoService  {

    private final TransacaoRepository transacaoRepository;

    public Transacao salvar(Transacao transacao){
        return transacaoRepository.save(transacao);

    }

    public List<Transacao> listarTodos(){
        return transacaoRepository.findAll();
    }

    public Optional<Transacao> buscarPorId(Long id){

        return transacaoRepository.findById(id);
    }

    public void deletar(Long id){

        transacaoRepository.deleteById(id);
    }

}
