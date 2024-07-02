package com.libreria.peterson.infrastructure.principal;

import com.libreria.peterson.app.service.SearchBookByTitleService;
import com.libreria.peterson.app.service.ShowAllAuthorsService;
import com.libreria.peterson.app.service.ShowAllBookService;
import com.libreria.peterson.app.service.ShowAuthorByYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
        int option = 1;
        String texto = """
                Seleccione un lenguaje
                1. Español [Es]
                2. Ingles [En]
                3. Frances [Fr]
                """;
        String menu = "Menú:\n" +
                "1. Buscar Libro por título\n" +
                "2. Mostrar todos los libros\n" +
                "3. Listar todos los autores\n" +
                "4. Mostrar Autores vivos en determinado año\n" +
                "5. Buscar Libro por un determinado idioma\n" +
                "0. Salir\n" +
                "Seleccione una opción: ";

        while (option != 0 ) {
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
                        searchService.FindBook(title);
                    } catch (TitleExistsException f) {
                        System.err.println(f.getMessage());
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    } catch (NoSuchElementException s) {
                        System.err.println("Libro no encontrado");
                    }
                    break;
                case 2:
                    showAllBookService.showAll();
                    break;
                case 3:
                    showAllAuthorsService.showAllAuthors();
                    // Implementar opción 3
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Escriba el año del author");
                    String ano = input.nextLine();
                    showAuthorByYear.showAuthorsByYear(ano);
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
