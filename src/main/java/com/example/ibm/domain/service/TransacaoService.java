package com.example.ibm.domain.service;

import com.example.ibm.domain.entity.Cliente;
import com.example.ibm.domain.entity.Produto;
import com.example.ibm.domain.entity.Transacao;
import com.example.ibm.domain.repository.TransacaoRepository;
import com.example.ibm.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;
    public Transacao salvar(Transacao transacao) {

        Optional<Produto> produtoOptional = produtoService.buscarPorId(transacao.getProduto().getId());
        Optional<Cliente> clienteOptional = clienteService.buscarPorId(transacao.getCliente().getId());

        if (produtoOptional.isEmpty()) {

               throw new BusinessException("Cliente não encontrado");
        }
        if (clienteOptional.isEmpty()) {
            throw new BusinessException("Produto não encontrado");
        }

        transacao.setProduto(produtoOptional.get());
        transacao.setCliente(clienteOptional.get());
        transacao.setData(LocalDateTime.now());


        return transacaoRepository.save(transacao);

    }





}
