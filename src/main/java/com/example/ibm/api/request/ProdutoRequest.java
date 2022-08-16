package com.example.ibm.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @NotBlank(message = "O tipo é obrigatório!")
    private String tipo;

    @NotBlank(message = "O codigo de barras é obrigatório!")
    private String codigoDeBarras;

    @NotNull(message = "O preço é obrigatório!")
    private Double preco;

    @NotNull(message = "A quantidade é obrigatório!")
    private Integer quantidade;
}
