package com.wklinkowski.manager_lounge.entities;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

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
    private MarcaCarvao marcaCarvao;

    @Column(nullable = false)
    private Integer pesoCarvao = 1;

    @Column(nullable = false)
    private Integer quantidadeCarvao = 1;

    public CarvaoEntity (CarvaoDTO carvaoDTO){
        BeanUtils.copyProperties(carvaoDTO, this);
    }
}
