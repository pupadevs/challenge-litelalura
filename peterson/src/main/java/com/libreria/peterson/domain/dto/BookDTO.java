package com.libreria.peterson.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.libreria.peterson.domain.entity.Author;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(
        String title,
        List<Author> authors,
        List<String> languages,
        @JsonAlias("download_count") String numDl) {
}
