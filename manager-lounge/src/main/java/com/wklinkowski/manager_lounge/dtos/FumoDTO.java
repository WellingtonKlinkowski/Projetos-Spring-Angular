package com.wklinkowski.manager_lounge.dtos;

import com.wklinkowski.manager_lounge.enums.MarcasFumo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FumoDTO {

    @NotNull(message = "A marca do fumo não pode estar vazio.")
    @Enumerated(EnumType.STRING)
    private MarcasFumo marcasFumo;

    @NotBlank(message = "O sabor não pode estar vazio.")
    @Size(min = 3, max = 100, message = "O sabor deve ter entre 3 a 100 letras.")
    private String saborFumo;

    @Min(value = 1, message = "O fumo não pode pesar menos de 1g.")
    private Integer pesoFumo = 1;

    @Min(value = 1, message = "A quantidade de caixa de fumo não pode ser menor que 1.")
    private Integer quantidadeEstoqueFumo = 1;

    @Setter(AccessLevel.NONE)
    private Integer quantidadeTotalFumo;
}