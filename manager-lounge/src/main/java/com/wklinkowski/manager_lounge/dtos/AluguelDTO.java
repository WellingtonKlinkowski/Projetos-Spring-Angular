package com.wklinkowski.manager_lounge.dtos;

import com.wklinkowski.manager_lounge.entities.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.Duration;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AluguelDTO {

    @Min(value = 1, message = "O número da mesa mínimo para o aluguel é 1.")
    private Integer numeroMesaAluguel;

    @NotNull(message = "O fumo não pode estar vazio.")
    private FumoEntity fumoAluguel;

    @NotNull(message = "O carvão não pode estar vazio.")
    private CarvaoEntity carvaoAluguel;

    @NotNull(message = "O rosh não pode estar vazio.")
    private RoshEntity roshAluguel;

    @NotNull(message = "A narguile não pode estar vazia.")
    private NarguileEntity narguileAluguel;

    @NotNull(message = "A duração do aluguel não pode estar vazio.")
    private Duration duracaoAluguel;

    @NotNull(message = "É preciso informar a situação em que o aluguel está.")
    private boolean ativoAluguel;
}
