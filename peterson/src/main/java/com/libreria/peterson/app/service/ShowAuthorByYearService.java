package com.libreria.peterson.app.service;

import com.libreria.peterson.domain.entity.Author;
import com.libreria.peterson.infrastructure.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowAuthorByYearService {

    @Autowired
   private AuthorRepository authorRepository;

    public void showAuthorsByYear(String year){

    List<Author> authorList = authorRepository.findAuthorsAliveInYear(year);
//
    authorList.stream().sorted(Comparator.comparing(Author::getBirth_year)).collect(Collectors.toList()).forEach(System.out::println);

    }
}
