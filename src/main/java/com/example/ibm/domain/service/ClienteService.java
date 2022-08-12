package com.example.ibm.domain.service;

import com.example.ibm.domain.entity.Cliente;
import com.example.ibm.domain.repository.ClienteRepository;
import com.example.ibm.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        boolean existeCpf = false;
        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cliente.getCpf());
        if(clienteOptional.isPresent()){
            if(!clienteOptional.get().getId().equals(cliente.getId())){

                existeCpf = true;

            }
        }
        if(existeCpf){
            throw new BusinessException("CPF JÁ CADASTRADO");
        }

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){

        return clienteRepository.findById(id);
    }

    public Optional<Cliente> buscarPorCpf(String cpf){

        return clienteRepository.findByCpf(cpf);
    }

    public void deletar(Long id){

        clienteRepository.deleteById(id);
    }




}
