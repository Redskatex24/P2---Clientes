package com.duoc.clientes.controller;

import com.duoc.clientes.dto.ClientesDTO;
import com.duoc.clientes.dto.ClientesRequest;
import com.duoc.clientes.service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {
    @Autowired
    private ClientesService clientesService;

    @GetMapping
    public ResponseEntity<List<ClientesDTO>> listarClientes(@RequestParam(required = false) String nombre) {
        List<ClientesDTO> clientes;
        if (nombre != null) {
            clientes = clientesService.buscarPorNombre(nombre);
        } else {
            clientes = clientesService.listar();
        }
        if (clientes.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ClientesDTO> guardarClientes(@Valid @RequestBody ClientesRequest request) {
        return new ResponseEntity<>(clientesService.guardar(request), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientesDTO> buscarPorId(@PathVariable int id){
        try{
            return new ResponseEntity<>(clientesService.buscarPorId(id), HttpStatus.OK);}
        catch (NullPointerException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientesDTO> atualizarClientes(@PathVariable int id, @Valid @RequestBody ClientesRequest request) {
        try{
            return new ResponseEntity<>(clientesService.actualizar(id, request), HttpStatus.OK);}
        catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClientes(@PathVariable int id){
        clientesService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
