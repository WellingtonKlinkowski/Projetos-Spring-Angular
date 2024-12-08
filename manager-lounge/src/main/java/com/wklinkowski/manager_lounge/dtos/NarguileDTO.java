package com.wklinkowski.manager_lounge.dtos;

import com.wklinkowski.manager_lounge.entities.NarguileEntity;
import com.wklinkowski.manager_lounge.enums.MarcasNarguile;
import com.wklinkowski.manager_lounge.enums.MaterialNarguile;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class NarguileDTO {

    @NotBlank(message = "O nome não pode estar vazio.")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 a 50 letras.")
    private String nomeNarguile;

    @NotNull(message = "A marca não pode estar vazia.")
    private MarcasNarguile marcasNarguile;

    @Min(value = 1, message = "A narguile deve ter mangueiras.")
    private Integer quantidadeMangueirasNarguile = 1;

    @NotNull(message = "O material não pode estar vazio.")
    private MaterialNarguile materialNarguile;

    public NarguileDTO (NarguileEntity narguileEntity){
        BeanUtils.copyProperties(narguileEntity, this);
    }
}
