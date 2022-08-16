package com.example.ibm.api.mapper;


import com.example.ibm.api.request.ClienteRequest;
import com.example.ibm.api.request.TransacaoRequest;
import com.example.ibm.api.response.TransacaoResponse;
import com.example.ibm.domain.entity.Transacao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransacaoMapper {

    private final ModelMapper mapper;





    public Transacao toTransacao(TransacaoRequest request) {

        return mapper.map(request, Transacao.class);


    }

    public TransacaoResponse toTransacaoResponse(Transacao transacao) {

        return mapper.map(transacao, TransacaoResponse.class);
    }


}
