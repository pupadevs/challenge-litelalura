package com.libreria.peterson.app.service;

import com.libreria.peterson.app.json.TransformJson;
import com.libreria.peterson.domain.dto.BookDTO;
import com.libreria.peterson.domain.dto.DataDTO;
import com.libreria.peterson.domain.entity.Author;
import com.libreria.peterson.domain.entity.Book;
import com.libreria.peterson.domain.interfaces.ApiRequestInterface;
import com.libreria.peterson.infrastructure.principal.TitleExistsException;
import com.libreria.peterson.infrastructure.repository.AuthorRepository;
import com.libreria.peterson.infrastructure.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Optional;

@Service
public class SearchBookByTitleService {
    private final BookRepository bookRepository;
    private final ApiRequestInterface apiRequestInterface;
    private  final AuthorRepository authorRepository;
    private final TransformJson transformJson;

    @Autowired
    public SearchBookByTitleService(BookRepository bookRepository, ApiRequestInterface apiRequestInterface, AuthorRepository authorRepository, TransformJson transformJson) {
        this.bookRepository = bookRepository;
        this.apiRequestInterface = apiRequestInterface;
        this.authorRepository = authorRepository;
        this.transformJson = transformJson;
    }

    public Book FindBook(String title) throws IOException, InterruptedException, TitleExistsException {

        String titleSanitized = title.replace(" ", "+").toLowerCase();
        String book = this.apiRequestInterface.makeRequest(titleSanitized);

        DataDTO data = this.transformJson.obtenerDatos(book, DataDTO.class);

        Optional<BookDTO> findbook = data.results().stream()
                .filter(b -> b.title().toUpperCase().contains(title.toUpperCase()))
                .findFirst();

        if (findbook.isEmpty()) {
        throw new TitleExistsException();
        }

         TitleExist(findbook);
        Author author = authorexist(findbook);

        BookDTO bk = findbook.get();
        Book object = new Book(bk);
        object.setAuthor(author);
        bookRepository.save(object);

        return object;

    }

    private void TitleExist(Optional<BookDTO> data){
        Optional<Book> aux = bookRepository.findAll().stream()
                .filter(b -> b.getTitle().toLowerCase().contains(data.get().title().toLowerCase()))
                .findFirst();

        if (aux.isPresent()) {
            throw new TitleExistsException();
        }
    }

    private Author authorexist(Optional<BookDTO> data){
        Optional<Author> aux = authorRepository.findAll().stream()
                .filter(b -> b.getName().toLowerCase().contains(data.get().authors().get(0).getName().toLowerCase()))
                .findFirst();
        if (aux.isEmpty()) {
            return data.get().authors().get(0);
        }
        return aux.get();

    }
}
