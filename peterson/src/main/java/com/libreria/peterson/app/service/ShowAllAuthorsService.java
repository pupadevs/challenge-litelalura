package com.libreria.peterson.app.service;

import com.libreria.peterson.domain.entity.Author;
import com.libreria.peterson.infrastructure.repository.AuthorRepository;
import com.libreria.peterson.infrastructure.repository.BookRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowAllAuthorsService {

    @Autowired
    private AuthorRepository authorRepository;

    public void showAllAuthors(){
    List<Author> authors= authorRepository.findAll().stream().sorted(Comparator.comparing(Author::getName)).
                collect(Collectors.toList());
    authors.forEach(au -> System.out.println(au.toString()));
    }
}
