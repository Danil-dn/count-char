package com.count.ch.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharactersDto{

    @Schema(example = "aaaaabcccc")
    @NotNull
    String string;
}
