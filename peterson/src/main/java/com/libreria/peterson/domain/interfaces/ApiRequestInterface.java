package com.libreria.peterson.domain.interfaces;

import java.io.IOException;

public interface ApiRequestInterface {

     String makeRequest(String title) throws IOException, InterruptedException ;
}
