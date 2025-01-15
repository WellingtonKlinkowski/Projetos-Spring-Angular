package com.wklinkowski.manager_lounge.entities;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name = "CARVOES")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class CarvaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MarcaCarvao marcaCarvao;

    @Column(nullable = false)
    private Integer pesoCarvao = 1;

    @Column(nullable = false)
    private Integer quantidadeCarvao = 1;

    @Column(nullable = false)
    private Integer quantidadeEstoqueCarvao = 1;

    @OneToMany(mappedBy = "id")
    private List<AluguelEntity> aluguelCarvao;

    public CarvaoEntity (CarvaoDTO carvaoDTO){
        BeanUtils.copyProperties(carvaoDTO, this);
    }
}
