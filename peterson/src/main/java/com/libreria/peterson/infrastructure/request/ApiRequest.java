package com.libreria.peterson.infrastructure.request;

import com.libreria.peterson.domain.interfaces.ApiRequestInterface;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//Para poder inyectar dependencias a un componente
@Component
public class ApiRequest implements ApiRequestInterface {
    private static final String URL_BASE = "https://gutendex.com/books/?search=";

    @Override
    public  String makeRequest(String title) throws  InterruptedException {
        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construir la solicitud HTTP GET
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_BASE + title )).build();

        // Enviar la solicitud y recibir la respuesta
        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //    client.close();

        } catch (IOException e) {
            throw new RuntimeException(e);

        }




        return response.body();
    }
}
