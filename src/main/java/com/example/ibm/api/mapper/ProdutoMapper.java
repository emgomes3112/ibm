package com.example.ibm.api.mapper;

import com.example.ibm.api.request.ProdutoRequest;
import com.example.ibm.api.response.ProdutoResponse;
import com.example.ibm.domain.entity.Produto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class ProdutoMapper {

    private final ModelMapper mapper;

    public Produto toProduto(ProdutoRequest request) {

        return mapper.map(request, Produto.class);
    }

    public ProdutoResponse toProdutoResponse(Produto produto) {

        return mapper.map(produto, ProdutoResponse.class);
    }

    public ProdutoResponse toProdutoResponsePorId(Produto produto) {
        return mapper.map(produto, ProdutoResponse.class);
    }

    public ProdutoResponse toProdutoResponseCodigoDeBarras(Produto produto) {
        return mapper.map(produto, ProdutoResponse.class);
    }

    public List<ProdutoResponse> toProdutoResponseList(List<Produto> produto) {
        return produto.stream()
                .map(this::toProdutoResponse)
                .collect(Collectors.toList());
    }
}
