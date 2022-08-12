package com.example.ibm.domain.service;


import com.example.ibm.domain.entity.Medicamento;
import com.example.ibm.domain.repository.MedicamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public Medicamento salvar(Medicamento medicamento){
        return medicamentoRepository.save(medicamento);

    }

    public List<Medicamento> listarTodos(){
        return medicamentoRepository.findAll();
    }

    public Optional<Medicamento> buscarPorId(Long id){

        return medicamentoRepository.findById(id);
    }

    public void deletar(Long id){

        medicamentoRepository.deleteById(id);
    }
}
