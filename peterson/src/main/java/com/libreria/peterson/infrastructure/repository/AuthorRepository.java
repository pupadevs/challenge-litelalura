package com.libreria.peterson.infrastructure.repository;

import com.libreria.peterson.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface AuthorRepository extends JpaRepository<Author, UUID> {

    Optional<Author> findByNameIgnoreCase(String name);
    @Query("SELECT a FROM Author a WHERE a.birth_year <= :year AND a.death_year >= :year")
    List<Author> findAuthorsAliveInYear(@Param("year") String year);

}
