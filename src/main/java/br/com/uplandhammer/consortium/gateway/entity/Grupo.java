package br.com.uplandhammer.consortium.gateway.entity;

import br.com.uplandhammer.consortium.gateway.entity.converter.StringToBooleanConverter;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "grupo")
public class Grupo {

    @Id
    @Column(name = "id_grupo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<Participante> participantes;
    @Column
    private String descricao;
    @Column
    private BigDecimal valor;
    @Column(name = "data_vigencia_inicial")
    private LocalDate dataVigenciaInicial;
    @Column(name = "data_vigencia_final")
    private LocalDate dataVigenciaFinal;
    @Column
    @Convert(converter = StringToBooleanConverter.class)
    private boolean ativo;
    @Column(name = "dia_pagamento")
    private Integer diaPagamento;



}
