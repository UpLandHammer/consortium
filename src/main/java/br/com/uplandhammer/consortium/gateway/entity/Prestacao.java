package br.com.uplandhammer.consortium.gateway.entity;

import br.com.uplandhammer.consortium.gateway.entity.converter.StringToBooleanConverter;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prestacao")
public class Prestacao {

    @Id
    @Column(name = "id_prestacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "id_participante", referencedColumnName = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    @Column(name = "numero_prestacao")
    private Integer numeroPrestacao;
    private BigDecimal valor;
    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Convert(converter = StringToBooleanConverter.class)
    private boolean status;

}
