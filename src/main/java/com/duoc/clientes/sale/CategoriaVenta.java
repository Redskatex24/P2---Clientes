package com.duoc.clientes.sale;

import com.duoc.clientes.dto.CategoriaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "platzi-store", url = "${platzi.api.url:https://api.escuelajs.co/api/v1}")
public interface CategoriaVenta {

    @GetMapping("/categories")
    List<CategoriaDTO> obtenerCategorias();
}
