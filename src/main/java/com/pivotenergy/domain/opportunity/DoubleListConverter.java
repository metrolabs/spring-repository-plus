package com.pivotenergy.domain.opportunity;

import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class DoubleListConverter implements AttributeConverter<List<Double>, String> {

    public String convertToDatabaseColumn(List<Double> values) {
        StringBuilder sb = new StringBuilder();
        for (Double value : values) {
            sb.append(value + ",");
        }
        String string = sb.toString();

        if(null != string && string.contains(",")) {
            string = string.substring(0, string.lastIndexOf(","));
        }
        return string;
    }

    public List<Double> convertToEntityAttribute(String values) {
        return toList(values);
    }

    public static List<Double> toList(String stingValue) {

        if (stingValue == null || stingValue.isEmpty()) {
            return new ArrayList<>();
        }

        return Arrays
                .stream(StringUtils.trimAllWhitespace(stingValue).split(","))
                .map(Double::valueOf)
                .collect(Collectors.toList());
    }
}
