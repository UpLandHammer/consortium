package br.com.uplandhammer.consortium.gateway.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringToBooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean ativo) {
        return Boolean.TRUE.equals(ativo) ? "S" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String ativo) {
        return ativo.equalsIgnoreCase("S");
    }
}
