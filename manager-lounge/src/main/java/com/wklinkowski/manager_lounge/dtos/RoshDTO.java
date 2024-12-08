package com.wklinkowski.manager_lounge.dtos;

import com.wklinkowski.manager_lounge.entities.RoshEntity;
import com.wklinkowski.manager_lounge.enums.MarcasRosh;
import com.wklinkowski.manager_lounge.enums.MaterialRosh;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class RoshDTO {

    @NotNull(message = "A marca do rosh não pode estar vazia.")
    private MarcasRosh marcasRosh;

    @NotNull(message = "O material do rosh não pode estar vazio.")
    private MaterialRosh materialRosh;

    public RoshDTO (RoshEntity roshEntity){
        BeanUtils.copyProperties(roshEntity, this);
    }
}
