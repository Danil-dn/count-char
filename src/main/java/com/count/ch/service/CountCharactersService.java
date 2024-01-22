package com.count.ch.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CountCharactersService {

    /**
     * Метод подсчитывает элементы массива и возвращает отсортированную hash-таблицу
     * */
    public Map<Character, Integer> count(char[] characters) {
        Map<Character, Integer> characterCount = new HashMap<>();
        for (char character : characters) {
            characterCount.put(character, characterCount.getOrDefault(character, 0) + 1);
        }
        Map<Character, Integer> sortedCharacterCount = new LinkedHashMap<>();
        characterCount.entrySet()
                .stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(entry -> sortedCharacterCount.put(entry.getKey(), entry.getValue()));

        return sortedCharacterCount;
    }
}
