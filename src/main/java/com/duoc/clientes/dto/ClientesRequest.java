package com.duoc.clientes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

    @Data
    public class ClientesRequest {
        @NotBlank(message = "el nombre no puede estar vacío")
        private String nombre;

        @NotBlank(message = "el número no puede estar vacío")
        private int numero;
}
