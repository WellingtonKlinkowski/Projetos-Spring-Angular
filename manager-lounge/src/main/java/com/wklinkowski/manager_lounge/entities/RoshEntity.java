package com.wklinkowski.manager_lounge.entities;

import com.wklinkowski.manager_lounge.dtos.RoshDTO;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name = "ROSHS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoshEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MarcasRosh marcasRosh;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaterialRosh materialRosh;

    @Column(nullable = false)
    private Integer quantidadeEstoqueRosh = 1;

    @OneToMany(mappedBy = "id")
    private List<AluguelEntity> aluguelRosh;
}
