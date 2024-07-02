package com.libreria.peterson.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorDTO(String name, String birth_year, String death_year) {
}
