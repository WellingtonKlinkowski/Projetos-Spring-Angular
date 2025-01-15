package com.wklinkowski.manager_lounge.entities;

import com.wklinkowski.manager_lounge.dtos.FumoDTO;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name = "FUMOS")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class FumoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MarcasFumo marcasFumo;

    @Column(nullable = false)
    private String saborFumo;

    @Column(nullable = false)
    private Integer pesoFumo = 1;

    @Column(nullable = false)
    private Integer quantidadeEstoqueFumo = 1;

    @OneToMany(mappedBy = "id")
    private List<AluguelEntity> aluguelFumo;

    public FumoEntity (FumoDTO fumoDTO){
        BeanUtils.copyProperties(fumoDTO, this);
    }
}
