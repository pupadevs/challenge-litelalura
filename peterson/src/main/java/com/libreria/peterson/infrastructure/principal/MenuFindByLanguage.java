package com.libreria.peterson.infrastructure.principal;

import com.libreria.peterson.app.service.SearchBookByLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuFindByLanguage {
    @Autowired
    private SearchBookByLanguageService service;
    public void MenuLanguage(int num){

        switch (num){
            case 1:service.findBookbyLanguage("ES");
                break;
            case 2:service.findBookbyLanguage("EN");
                break;
            case 3:service.findBookbyLanguage("FR");
                break;
        }
    }
}
