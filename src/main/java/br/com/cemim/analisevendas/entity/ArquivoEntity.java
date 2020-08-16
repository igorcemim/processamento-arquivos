package br.com.cemim.analisevendas.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ArquivoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String caminho;

    private String status;
}
