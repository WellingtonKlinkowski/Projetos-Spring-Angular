package com.wklinkowski.manager_lounge.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * Converter criado para auxiliar no save do banco
 * e na apresentação dos dados.
 * Essa classe evita erro pelo tipo de dado salvo
 * no banco, convertendo para Long e posteriormente
 * convertendo para Duration na hora da apresentação.
 *
 * Obs: Usado somente para a entidade aluguel.
 *
 * @author WellingtonKlinkowski
 */
@Component
@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration, Long> {

    @Override
    public Long convertToDatabaseColumn(Duration durationData) {
        return durationData != null ? durationData.toSeconds() : null;
    }

    @Override
    public Duration convertToEntityAttribute(Long durationDatabase) {
        return durationDatabase != null ? Duration.ofSeconds(durationDatabase) : null;
    }
}
