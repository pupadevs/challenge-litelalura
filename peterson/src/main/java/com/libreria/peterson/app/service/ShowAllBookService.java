package com.libreria.peterson.app.service;

import com.libreria.peterson.domain.entity.Book;
import com.libreria.peterson.infrastructure.repository.BookRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowAllBookService {
    @Autowired
    private BookRepositoryInterface bookrepository;
    public void  showAll(){
        List<Book> books = bookrepository.findAll();
       // String klk = books.getFirst().getTitle();
        List<Book> sortedBooks = books.stream()
                .sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());

        sortedBooks.forEach( bk -> System.out.println(bk.toString()));




    }
}
