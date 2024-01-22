package com.count.ch.controller;

import com.count.ch.dto.CharactersDto;
import com.count.ch.service.CountCharactersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CountCharacters {
    final CountCharactersService countCharactersService;

    @Autowired
    public CountCharacters(CountCharactersService countCharactersService) {
        this.countCharactersService = countCharactersService;
    }

    /**
    * Post-запрос на подсчет символов в переданной строке
    * */
    @PostMapping("/count")
    @Operation(summary = "Подсчет символов в строке")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Успешный запрос. Возвращает хеш-таблицу."),
            @ApiResponse(responseCode = "400", description = "Неверный запрос."),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера.")
    })
    public Map<Character, Integer> count(
            final @RequestBody @Valid CharactersDto symbols
    ) {
        return countCharactersService.count(symbols.getString().toCharArray());
    }
}
