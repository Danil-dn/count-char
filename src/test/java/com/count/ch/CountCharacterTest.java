package com.count.ch;

import com.count.ch.service.CountCharactersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountCharacterTest {

    private CountCharactersService countCharactersService;

    @BeforeEach
    public void set() {
        countCharactersService = new CountCharactersService();
    }

    @Test
    public void testMultiChar() {
        char[] characters = {'a', 'a', 'a', 'c', 'b', 'b'};
        Map<Character, Integer> result = countCharactersService.count(characters);

        assertEquals(result.values().toArray()[2], result.get('c'));

        assertEquals(3, result.get('a').intValue());
        assertEquals(2, result.get('b').intValue());
        assertEquals(1, result.get('c').intValue());
    }

    @Test
    public void testSingleChar() {
        char[] characters = {'b'};
        Map<Character, Integer> result = countCharactersService.count(characters);

        assertEquals(1, result.size());

        assertEquals(1, result.get('b').intValue());
    }

    @Test
    public void testEmptyArray() {
        char[] characters = {};
        Map<Character, Integer> result = countCharactersService.count(characters);

        assertTrue(result.isEmpty());
    }
}
