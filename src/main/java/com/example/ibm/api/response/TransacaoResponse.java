package com.example.ibm.api.response;


import com.example.ibm.domain.entity.Cliente;
import com.example.ibm.domain.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoResponse {

    private Long id;
    private Cliente cliente;
    private Produto produto;
    private  double valor;
    private LocalDateTime data;
}
