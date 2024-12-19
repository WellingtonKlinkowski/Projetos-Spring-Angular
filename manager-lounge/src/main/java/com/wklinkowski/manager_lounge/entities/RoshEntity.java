package com.wklinkowski.manager_lounge.entities;

import com.wklinkowski.manager_lounge.dtos.RoshDTO;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "ROSHS")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
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

    public RoshEntity (RoshDTO roshDTO){
        BeanUtils.copyProperties(roshDTO, this);
    }
}
