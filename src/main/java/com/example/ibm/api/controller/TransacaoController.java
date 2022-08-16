package com.example.ibm.api.controller;


import com.example.ibm.api.mapper.ProdutoMapper;
import com.example.ibm.api.mapper.TransacaoMapper;
import com.example.ibm.api.request.ProdutoRequest;
import com.example.ibm.api.request.TransacaoRequest;
import com.example.ibm.api.response.ProdutoResponse;
import com.example.ibm.api.response.TransacaoResponse;
import com.example.ibm.domain.entity.Produto;
import com.example.ibm.domain.entity.Transacao;
import com.example.ibm.domain.service.ProdutoService;
import com.example.ibm.domain.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoMapper mapper;

    private final TransacaoService service;

    @PostMapping
    public ResponseEntity<TransacaoResponse> salvar(@Valid @RequestBody TransacaoRequest request) {

        Transacao transacao = mapper.toTransacao(request);
        Transacao transacaoSalva = service.salvar(transacao);
        TransacaoResponse response = mapper.toTransacaoResponse(transacaoSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
