package com.libreria.peterson.app.json;

public interface TransformJsonInterface {
    <T> T obtenerDatos (String json, Class<T> clase);
}
