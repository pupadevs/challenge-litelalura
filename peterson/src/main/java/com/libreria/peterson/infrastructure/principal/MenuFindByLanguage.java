package com.libreria.peterson.infrastructure.principal;

import com.libreria.peterson.app.service.SearchBookByLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuFindByLanguage {
    @Autowired
    private SearchBookByLanguageService service;
    public void MenuLanguage(int num){
        String result;
        switch (num){
            case 1:
                 result = service.findBookbyLanguage("ES");
                System.out.println(result);
                break;
            case 2: result = service.findBookbyLanguage("EN");
                System.out.println(result);

                break;
            case 3:service.findBookbyLanguage("FR");
                break;
        }
    }
}
