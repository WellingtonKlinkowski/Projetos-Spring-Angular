package com.wklinkowski.manager_lounge.entities;

import com.wklinkowski.manager_lounge.dtos.CarvaoDTO;
import com.wklinkowski.manager_lounge.enums.MarcaCarvao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name = "CARVOES")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private Integer quantidadeEstoqueCaixaCarvao = 1;

    @Column(nullable = false)
    private Integer quantidadeTotalCarvao;

    @OneToMany(mappedBy = "id")
    private List<AluguelEntity> aluguelCarvao;

    public void calculaQuantidadeTotalDeCarvao() {
        this.quantidadeTotalCarvao = quantidadeEstoqueCaixaCarvao * quantidadeCarvao;
    }
}
