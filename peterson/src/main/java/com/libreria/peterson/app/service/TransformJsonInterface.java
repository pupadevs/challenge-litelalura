package com.libreria.peterson.app.service;

public interface TransformJsonInterface {
    <T> T obtenerDatos (String json, Class<T> clase);
}
