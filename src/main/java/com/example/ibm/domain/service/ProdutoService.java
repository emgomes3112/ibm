package com.example.ibm.domain.service;


import com.example.ibm.domain.entity.Produto;
import com.example.ibm.domain.repository.ProdutoRepository;
import com.example.ibm.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto){

        boolean existeCodigoDeBarras = false;
        Optional<Produto> produtoOptional = produtoRepository.findByCodigoDeBarras(produto.getCodigoDeBarras());
        if(produtoOptional.isPresent()){
            if(!produtoOptional.get().getId().equals(produto.getId())){

                existeCodigoDeBarras = true;

            }
        }
        if(existeCodigoDeBarras){
            throw new BusinessException("CODIGO DE BARRAS JÁ CADASTRADO");
        }
        return produtoRepository.save(produto);

    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){

        return produtoRepository.findById(id);
    }
    public Optional<Produto> buscarCodigoDeBarras(String codigoDeBarras){

        return produtoRepository.findByCodigoDeBarras(codigoDeBarras);
    }

    public void deletar(Long id){

        produtoRepository.deleteById(id);
    }
}
