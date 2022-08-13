package com.example.ibm.api.mapper;

import com.example.ibm.api.request.ClienteRequest;
import com.example.ibm.api.response.ClienteResponse;
import com.example.ibm.domain.entity.Cliente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

    private final ModelMapper mapper;

    public Cliente toCliente(ClienteRequest request) {
        return mapper.map(request, Cliente.class);
    }

    public ClienteResponse toClienteResponse(Cliente cliente) {
        return mapper.map(cliente, ClienteResponse.class);
    }

    public ClienteResponse toClienteResponsePorId(Cliente cliente) {
        return mapper.map(cliente, ClienteResponse.class);
    }

    public ClienteResponse toClienteResponsePorCpf(Cliente cliente) {
        return mapper.map(cliente, ClienteResponse.class);
    }

    public List<ClienteResponse> toClienteResponseList(List<Cliente> clientes) {
        return clientes.stream()
                .map(this::toClienteResponse)
                .collect(Collectors.toList());
    }
}
