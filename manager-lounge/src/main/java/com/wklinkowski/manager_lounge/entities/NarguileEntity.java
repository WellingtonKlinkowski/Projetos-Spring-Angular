package com.wklinkowski.manager_lounge.entities;

import com.wklinkowski.manager_lounge.dtos.NarguileDTO;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "NARGUILES")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class NarguileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeNarguile;

    @Column(nullable = false)
    private MarcasNarguile marcasNarguile;

    @Column(nullable = false)
    private Integer quantidadeMangueirasNarguile = 1;

    @Column(nullable = false)
    private MaterialNarguile materialNarguile;

    public NarguileEntity (NarguileDTO narguileDTO){
        BeanUtils.copyProperties(narguileDTO, this);
    }
}
