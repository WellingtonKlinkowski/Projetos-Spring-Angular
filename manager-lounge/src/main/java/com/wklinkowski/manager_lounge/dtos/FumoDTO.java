package com.wklinkowski.manager_lounge.dtos;

import com.wklinkowski.manager_lounge.entities.FumoEntity;
import com.wklinkowski.manager_lounge.enums.MarcasFumo;
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
public class FumoDTO {

    @NotNull(message = "A marca do fumo não pode estar vazio.")
    private MarcasFumo marcasFumo;

    @NotBlank(message = "O sabor não pode estar vazio.")
    @Size(min = 3, max = 100, message = "O sabor deve ter entre 3 a 100 letras.")
    private String saborFumo;

    @Min(value = 1, message = "O fumo não pode pesar menos de 1g.")
    private Integer pesoFumo = 1;

    public FumoDTO(FumoEntity fumoEntity) {
        BeanUtils.copyProperties(fumoEntity, this);
    }
}