package com.pivotenergy.domain.opportunity;

import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class StringSetConverter implements AttributeConverter<Set<String>, String> {

    public String convertToDatabaseColumn(Set<String> values) {
        StringBuilder sb = new StringBuilder();
        for (String string : values) {
            sb.append(string + ",");
        }
        String string = sb.toString();

        if(null != string && string.contains(",")) {
            string = string.substring(0, string.lastIndexOf(","));
        }
        return string;
    }

    public Set<String> convertToEntityAttribute(String value) {
        return toSet(value);
    }

    public static Set<String> toSet(String value) {
        return Arrays
                .stream(StringUtils.trimAllWhitespace(value).split(","))
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }
}
