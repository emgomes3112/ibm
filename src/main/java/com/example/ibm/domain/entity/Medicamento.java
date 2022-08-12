package com.example.ibm.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;




@Getter
@Setter
@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "marca")
    private String marca;

    @Column(name = "codigo_de_barras")
    private String codigoDeBarras;

    @Column(name = "valor")
    private Number valor;

    @ManyToOne
    private Cliente cliente;

}
