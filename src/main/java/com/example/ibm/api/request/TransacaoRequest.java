package com.example.ibm.api.request;

import com.example.ibm.domain.entity.Cliente;
import com.example.ibm.domain.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoRequest {

    @NotNull(message = "A quantidade é obrigatório!")
    private Long clienteId;

    @NotNull(message = "A quantidade é obrigatório!")
    private Long produtoId;
    private  double valor;



}
