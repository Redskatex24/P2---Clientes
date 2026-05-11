package com.duoc.clientes.exeption;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(String nombre) {
        super("Categoria no encontrada con nombre: " + nombre);
    }
}
