package com.libreria.peterson.domain.entity;

import com.libreria.peterson.domain.dto.BookDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Entity
@Table(name = "books")
@Getter


public class Book {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String title;

    @ManyToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    private String languages;

    private String numDownload;

    public Book(BookDTO data){
        this.id = UUID.randomUUID();
        this.title = data.title();
        this.author = data.authors().get(0);
        this.languages = String.join(", ",data.languages()) ;
        this.numDownload = data.numDl();


    }

    public Book(){}

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "**** Libro ****\n" +
                "ID: " + id + "\n" +
                "Título: " + title + "\n" +
                "Autor: " + (author != null ? author.getName() : "N/A") + "\n" +
                "Idiomas: " + languages + "\n" +
                "Descargas: " + numDownload;
    }


}
