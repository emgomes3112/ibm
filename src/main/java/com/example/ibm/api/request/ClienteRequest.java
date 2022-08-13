package com.example.ibm.api.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {


    private String name;
    private String dataDeNascimento;
    private String telefone;
    private String email;
    private String cpf;
}
