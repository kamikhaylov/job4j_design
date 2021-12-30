package ru.job4j.block04.template;

import java.util.Map;

public class GeneratorName implements Generator {
    @Override
    public String produce(String template, Map<String, String> args) {
        return "I am a Konstantin, Who are you?";
    }
}
