package com.duoc.clientes.service;

import com.duoc.clientes.dto.ClientesDTO;
import com.duoc.clientes.dto.ClientesRequest;
import com.duoc.clientes.model.ClientesModel;
import com.duoc.clientes.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    public ClientesDTO guardar(ClientesRequest request) {
        ClientesModel clientes = new ClientesModel();
        clientes.setNombre(request.getNombre());
        clientes.setNumero(request.getNumero());

        ClientesModel guardado = clientesRepository.save(clientes);
        return convertirADTO(guardado);
    }
    public List<ClientesDTO> listar() {
        return clientesRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    public ClientesDTO buscarPorId(int id) {
        ClientesModel clientes = clientesRepository.findById(id).orElseThrow(() -> new NullPointerException("Cliente no encontrado por el id: " + id));
        return convertirADTO(clientes);
    }
    public ClientesDTO actualizar(int id, ClientesRequest request) {
        ClientesModel clienteExistente = clientesRepository.findById(id).orElseThrow(() -> new NullPointerException("Cliente no encontrado"));
        clienteExistente.setNombre(request.getNombre());
        clienteExistente.setNumero(request.getNumero());

        ClientesModel actualizado = clientesRepository.save(clienteExistente);
        return convertirADTO(actualizado);
    }

    public void eliminar(int id) {
        clientesRepository.deleteById(id);
    }

    private ClientesDTO convertirADTO(ClientesModel clientes) {
        if(clientes == null) return null;
        ClientesDTO dto = new ClientesDTO();
        dto.setId(clientes.getId());
        dto.setNombre(clientes.getNombre());
        dto.setNumero(clientes.getNumero());
        return dto;
    }
}
