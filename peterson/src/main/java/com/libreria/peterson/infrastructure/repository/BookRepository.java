package com.libreria.peterson.infrastructure.repository;


import com.libreria.peterson.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    Optional<Book> findByTitle(String title);

    List<Book> findByLanguagesIgnoreCase(String language);

}
