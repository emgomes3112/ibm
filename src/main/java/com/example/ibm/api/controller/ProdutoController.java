package com.example.ibm.api.controller;


import com.example.ibm.api.mapper.ProdutoMapper;
import com.example.ibm.api.request.ProdutoRequest;
import com.example.ibm.api.response.ProdutoResponse;
import com.example.ibm.domain.entity.Produto;
import com.example.ibm.domain.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;
    private final ProdutoMapper mapper;

    @PostMapping
    public ResponseEntity<ProdutoResponse> salvar(@Valid @RequestBody ProdutoRequest request) {

        Produto produto = mapper.toProduto(request);
        Produto produtoSalvo = service.salvar(produto);
        ProdutoResponse response = mapper.toProdutoResponse(produtoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listarTodos() {

        List<Produto> produtos = service.listarTodos();
        List<ProdutoResponse> responses = mapper.toProdutoResponseList(produtos);
        return ResponseEntity.status(HttpStatus.OK).body(responses);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Long id) {

        Optional<Produto> produtoOptional = service.buscarPorId(id);
        if (produtoOptional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toProdutoResponsePorId(produtoOptional.get()));

    }

    @GetMapping("/codigo/{codigoDeBarras}")
    public ResponseEntity<ProdutoResponse> buscarPorCpf(@PathVariable String codigoDeBarras) {

        Optional<Produto> produtoOptional = service.buscarCodigoDeBarras(codigoDeBarras);
        if (produtoOptional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toProdutoResponseCodigoDeBarras(produtoOptional.get()));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Long id, @RequestBody ProdutoRequest request) {

        Produto produto = mapper.toProduto(request);
        Produto produtoSalvo = service.alterar(id, produto);
        ProdutoResponse response = mapper.toProdutoResponse(produtoSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
