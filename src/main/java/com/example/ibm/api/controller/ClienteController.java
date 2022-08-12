package com.example.ibm.api.controller;


import com.example.ibm.domain.entity.Cliente;
import com.example.ibm.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){

        Cliente clienteSalvo = service.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);

    }
    @GetMapping
    public ResponseEntity<List<Cliente>>  listarTodos(){

        List<Cliente> cliente = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(cliente);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente>  buscarPorId(@PathVariable Long id){

        Optional<Cliente> clienteOptional = service.buscarPorId(id);

        if(clienteOptional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());

    }
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente>  buscarPorCpf(@PathVariable String cpf){

        Optional<Cliente> clienteOptional = service.buscarPorCpf(cpf);

        if(clienteOptional.isEmpty()) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());

    }
    @PutMapping
    public  ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){

        Cliente clienteSalvo = service.salvar(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteSalvo);

    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
