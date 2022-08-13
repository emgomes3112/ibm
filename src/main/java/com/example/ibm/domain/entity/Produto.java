package com.example.ibm.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;




@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "codigo_de_barras")
    private String codigoDeBarras;

    @Column(name = "preco")
    private Double preco;


}
