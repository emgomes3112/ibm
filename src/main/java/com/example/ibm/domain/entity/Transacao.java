package com.example.ibm.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;




@Getter
@Setter
@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_transacao")
    private LocalDateTime data_transacao;

    @Column(name = "valor")
    private Double valor;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Medicamento medicamento;
}
