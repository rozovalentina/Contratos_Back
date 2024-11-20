package com.example.parcial.service;

import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.parcial.repository.*;
import com.example.parcial.DTO.*;
import com.example.parcial.entity.*;

@Service
public class ContratoService {

    private ContratoRepository repository;
    private final ModelMapper modelMapper;

    public ContratoService(ContratoRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public ContratoDTO crearContrato(ContratoDTO contratoDTO) {
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        contrato = repository.save(contrato);
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    public ContratoDTO actualizarContrato(Long id, ContratoDTO contratoDTO) {
        Contrato contrato = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        modelMapper.map(contratoDTO, contrato);
        contrato.setId(id);
        contrato = repository.save(contrato);
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    public void eliminarContrato(Long id) {
        repository.deleteById(id);
    }

    public List<ContratoDTO> listarContratos() {
        return repository.findAll().stream() // Transformar la lista a un stream
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class)) // Mapear cada objeto
                .collect(Collectors.toList()); // Colectar en una lista
    }
    

    public ContratoDTO obtenerContratoPorId(Long id) {
        Contrato contrato = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        return modelMapper.map(contrato, ContratoDTO.class);
    }
}
