package com.example.ibm.api.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @NotBlank(message = "O nome é obrigatório!")
    private String name;

    @NotBlank(message = "A data de nascimento é obrigatória")
    private String dataDeNascimento;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "O email é obrigatório!")
    private String email;


    @NotBlank(message = "O cpf é obrigatório!")
    private String cpf;
}
