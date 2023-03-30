package br.com.uplandhammer.consortium.gateway.entity;

import br.com.uplandhammer.consortium.gateway.entity.converter.StringToBooleanConverter;
import br.com.uplandhammer.consortium.gateway.entity.enums.TipoComunicacao;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participante")
public class Participante {

    @Id
    @Column(name = "id_participante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Grupo grupo;
    @Convert(converter = StringToBooleanConverter.class)
    private Boolean ativo;
    @Enumerated
    private TipoComunicacao tipoComunicacao;
    @Convert(converter = StringToBooleanConverter.class)
    private Boolean contemplado;
}
