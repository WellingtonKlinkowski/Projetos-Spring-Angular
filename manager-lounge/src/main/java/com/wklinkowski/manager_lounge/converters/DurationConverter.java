package com.wklinkowski.manager_lounge.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

import java.time.Duration;

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
