package com.example.ibm.api.controller;


import com.example.ibm.domain.entity.Produto;
import com.example.ibm.domain.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){

        Produto produtoSalvo = service.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);

    }
    @GetMapping
    public ResponseEntity<List<Produto>>  listarTodos(){

        List<Produto> produtos = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto>  buscarPorId(@PathVariable Long id){

        Optional<Produto> produtoOptional = service.buscarPorId(id);

        if(produtoOptional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());

    }
    @GetMapping("/codigo/{codigoDeBarras}")
    public ResponseEntity<Produto>  buscarPorCpf(@PathVariable String codigoDeBarras){

        Optional<Produto> produtoOptional = service.buscarCodigoDeBarras(codigoDeBarras);

        if(produtoOptional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());

    }
    @PutMapping
    public  ResponseEntity<Produto> atualizar(@RequestBody Produto produto){

        Produto produtoSalvo = service.salvar(produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoSalvo);

    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
