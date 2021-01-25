package com.complexica.travelforecast.common;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lombok.AccessLevel.PUBLIC;

@AllArgsConstructor(access = PUBLIC)
public enum Language {

    ENG(1, "en"), RO(2, "ro");

    public final Integer id;
    public final String name;

    public static List<Language> getSupportedLanguages() {
        return new ArrayList<>(Arrays.asList(Language.ENG, Language.RO));
    }
}
