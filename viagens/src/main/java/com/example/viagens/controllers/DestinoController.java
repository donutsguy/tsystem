package com.example.viagens.controllers;

import com.example.viagens.dtos.DestinoRecordDto;
import com.example.viagens.repositories.DestinoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.viagens.models.DestinoModel;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

    @Autowired
    DestinoRepository destinoRepository;

    @GetMapping
    public ResponseEntity<List<DestinoModel>> getAllDestinos() {
        return ResponseEntity.status(HttpStatus.OK).body(destinoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDestinoById(@PathVariable(value = "id") Long id) {
        Optional<DestinoModel> destinoO = destinoRepository.findById(id);
        if (destinoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(destinoO.get());
    }

    @PostMapping
    public ResponseEntity<DestinoModel> createDestino(@RequestBody @Valid DestinoRecordDto destinoDto) {
        var destinoModel = new DestinoModel();
        BeanUtils.copyProperties(destinoDto, destinoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(destinoRepository.save(destinoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDestino(@PathVariable(value = "id") Long id) {
        Optional<DestinoModel> destinoO = destinoRepository.findById(id);
        if (destinoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado");
        }

        destinoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Destino excluido com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDestino(@PathVariable(value = "id") Long id, @RequestBody @Valid DestinoRecordDto destinoDto) {
        Optional<DestinoModel> destinoO = destinoRepository.findById(id);
        if (destinoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        var destinoModel = destinoO.get();
        BeanUtils.copyProperties(destinoDto, destinoModel);
        return ResponseEntity.status(HttpStatus.OK).body(destinoRepository.save(destinoModel));
    }
}
