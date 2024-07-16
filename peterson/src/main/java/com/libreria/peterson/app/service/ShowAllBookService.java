package com.libreria.peterson.app.service;

import com.libreria.peterson.domain.entity.Book;
import com.libreria.peterson.infrastructure.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowAllBookService {
    @Autowired
    private BookRepository bookrepository;
    public List<Book>  showAll(){
        List<Book> books = bookrepository.findAll();

        return books;




    }
}
