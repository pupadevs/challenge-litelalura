package com.libreria.peterson.infrastructure.principal;

import com.libreria.peterson.app.service.SearchBookByTitleService;
import com.libreria.peterson.app.service.ShowAllAuthorsService;
import com.libreria.peterson.app.service.ShowAllBookService;
import com.libreria.peterson.app.service.ShowAuthorByYearService;
import com.libreria.peterson.domain.entity.Author;
import com.libreria.peterson.domain.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Menu {
    private final Scanner input;
    private final SearchBookByTitleService searchService;
    private final ShowAllBookService showAllBookService;
    private final ShowAllAuthorsService showAllAuthorsService;
   private final ShowAuthorByYearService showAuthorByYear;

   private final MenuFindByLanguage menu;

    @Autowired
    public Menu(SearchBookByTitleService searchService,
                ShowAllBookService showAllBookService,
                ShowAllAuthorsService showAllAuthorsService,
                ShowAuthorByYearService service, MenuFindByLanguage menu
    )
    {
        this.searchService = searchService;
        this.showAllBookService = showAllBookService;
       this.showAuthorByYear = service;
        this.showAllAuthorsService = showAllAuthorsService;
        this.menu = menu;
        this.input = new Scanner(System.in);
    }

    public void principal() {
        int option;
        String texto = """
                Seleccione un lenguaje
                1. Español [Es]
                2. Inglés [En]
                3. Frances [Fr.]
                """;
        String menu = """
                Menú:
                1. Buscar Libro por título
                2. Mostrar todos los libros
                3. Listar todos los autores
                4. Mostrar Autores vivos en determinado año
                5. Buscar Libro por un determinado idioma
                0. Salir
                Seleccione una opción:\s""";

        while (true) {
            System.out.println(menu);
            option = input.nextInt();

            switch (option) {
                case 1:
                    try {
                        input.nextLine();
                        System.out.println("Escriba el título del libro a buscar");
                        String title = input.nextLine();
                        System.out.println(title);
                      //
                       Book book =searchService.FindBook(title);
                        System.out.println(book);
                    } catch (TitleExistsException f) {
                        System.err.println(f.getMessage());
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    } catch (NoSuchElementException s) {
                        System.err.println("Libro no encontrado");
                    }
                    break;
                case 2:
                   List<Book> books= showAllBookService.showAll();
                    books.stream()
                            .sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList()).
                            forEach( bk -> System.out.println(bk.toString()));
                    break;
                case 3:
                    List<Author> authors = showAllAuthorsService.showAllAuthors();
                    authors.forEach(au -> System.out.println(au.toString()));
                    // Implementar opción 3
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Escriba el año del author");
                    String ano = input.nextLine();
                   List<Author> authorList= showAuthorByYear.showAuthorsByYear(ano);
                    authorList.stream().sorted(Comparator.comparing(Author::getBirth_year)).
                            collect(Collectors.toList()).forEach(System.out::println);
                    break;
                case 5:
                    System.out.println(texto);
                    int num = input.nextInt();
                    this.menu.MenuLanguage(num);

                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida, por favor seleccione una opción del menú.");
            }
        }
    }
}
