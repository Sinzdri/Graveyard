package com.qa.rp.domain;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CharacterRaceConverter implements Converter<String, CharacterRace> {

    @Override
    public CharacterRace convert(String value) {
        return CharacterRace.valueOf(value.toUpperCase());	// Prevents case sensitivity with requests
    }
}