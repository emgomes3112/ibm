package com.example.ibm.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {


    private Long id;
    private String name;
    private String dataDeNascimento;
    private String telefone;
    private String email;
    private String cpf;
}
