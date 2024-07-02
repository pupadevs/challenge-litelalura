package com.libreria.peterson.app.service;

import com.libreria.peterson.domain.entity.Book;
import com.libreria.peterson.infrastructure.repository.BookRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SearchBookByLanguageService {

    @Autowired
    private BookRepositoryInterface repository;

    public void findBookbyLanguage(String languaje){
        List<Book> books = repository.findByLanguagesIgnoreCase(languaje);

            books.stream().sorted(Comparator.comparing(Book::getLanguages)).collect(Collectors.toList()).forEach(System.out::println);

    }
}
