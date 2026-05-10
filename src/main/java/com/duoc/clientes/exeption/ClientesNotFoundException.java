package com.duoc.clientes.exeption;

public class ClientesNotFoundException extends RuntimeException {
    public ClientesNotFoundException(Integer id) {
        super("Cliente no encontrado con id: " + id);
    }
}