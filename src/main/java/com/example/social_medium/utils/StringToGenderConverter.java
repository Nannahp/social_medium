package com.example.social_medium.utils;

import com.example.social_medium.models.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToGenderConverter implements Converter<String, Gender> {

    @Override
    public Gender convert(String source) {
        return Gender.valueOf(source.toUpperCase());
    }

}