package com.libreria.peterson.domain.entity;

import com.libreria.peterson.domain.dto.AuthorDTO;
import jakarta.persistence.*;
import lombok.Getter;

import org.hibernate.annotations.GenericGenerator;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "authors")
@Getter



public class Author {


    //ID
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    //@Column(unique = true)
    private String name;
    private String birth_year;
    private String death_year;
    //Relacion 1:n
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books;

    public Author(AuthorDTO data){
    this.id = UUID.randomUUID().toString();
        this.name = data.name();
        this.birth_year = data.birth_year();
        this.death_year = data.death_year();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author(){}

    @Override
    public String toString() {
        String bookTitles = this.getBooks().stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(", "));

        return "**** Autor ****\n" +
                "ID: " + id + "\n" +
                "Nombre: " + name + "\n" +
                "Año de Nacimiento: " + birth_year + "\n" +
                "Año de Muerte: " + (death_year != null ? death_year : "N/A") + "\n" +
                "Libros: " + bookTitles;
    }

}



