package com.example.ibm.api.controller;


import com.example.ibm.api.mapper.ClienteMapper;
import com.example.ibm.api.request.ClienteRequest;
import com.example.ibm.api.response.ClienteResponse;
import com.example.ibm.domain.entity.Cliente;
import com.example.ibm.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;
    private final ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponse> salvar(@Valid @RequestBody ClienteRequest request) {


        Cliente cliente = mapper.toCliente(request);
        Cliente clienteSalvo = service.salvar(cliente);
        ClienteResponse response = mapper.toClienteResponse(clienteSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarTodos() {

        List<Cliente> clientes = service.listarTodos();
        List<ClienteResponse> responses = mapper.toClienteResponseList(clientes);
        return ResponseEntity.status(HttpStatus.OK).body(responses);


    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long id) {

        Optional<Cliente> clienteOptional = service.buscarPorId(id);
        if (clienteOptional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toClienteResponsePorId(clienteOptional.get()));

    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ClienteResponse> buscarPorCpf(@PathVariable String cpf) {

        Optional<Cliente> clienteOptional = service.buscarPorCpf(cpf);
        if (clienteOptional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toClienteResponsePorCpf(clienteOptional.get()));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable Long id, @RequestBody ClienteRequest request) {

        Cliente cliente = mapper.toCliente(request);
        Cliente clienteSalvo = service.alterar(id, cliente);
        ClienteResponse clienteResponse = mapper.toClienteResponse(clienteSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(clienteResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
