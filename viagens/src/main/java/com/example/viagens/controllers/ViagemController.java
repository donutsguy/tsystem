package com.example.viagens.controllers;

import com.example.viagens.dtos.ViagemRecordDto;
import com.example.viagens.repositories.ViagemRepository;
import com.example.viagens.repositories.DestinoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.viagens.models.DestinoModel;
import com.example.viagens.models.ViagemModel;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

    @Autowired
    ViagemRepository viagemRepository;

    @Autowired
    DestinoRepository destinoRepository;

    @GetMapping
    public ResponseEntity<List<ViagemModel>> getAllViagens() {
        return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getViagemById(@PathVariable(value = "id") Long id) {
        Optional<ViagemModel> viagemO = viagemRepository.findById(id);
        if (viagemO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(viagemO.get());
    }

    @PostMapping
    public ResponseEntity<ViagemModel> createViagem(@RequestBody @Valid ViagemRecordDto viagemDto) {
        var viagemModel = new ViagemModel();

        DestinoModel destino = destinoRepository.findById(viagemDto.destinoId())
                        .orElseThrow(()->new RuntimeException("Destino não encontrado"));

        BeanUtils.copyProperties(viagemDto, viagemModel);
        viagemModel.setDestino(destino);
        return ResponseEntity.status(HttpStatus.CREATED).body(viagemRepository.save(viagemModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteViagem(@PathVariable(value = "id") Long id) {
        Optional<ViagemModel> viagemO = viagemRepository.findById(id);
        if (viagemO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        viagemRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluido com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateViagem(@PathVariable(value = "id") Long id, @RequestBody @Valid ViagemRecordDto viagemRecordDto) {
        Optional<ViagemModel> viagemO = viagemRepository.findById(id);
        if (viagemO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        var viagemModel = viagemO.get();
        BeanUtils.copyProperties(viagemRecordDto, viagemModel);
        return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.save(viagemModel));
    }

    @GetMapping("/destinos/{id}/viagens")
    public ResponseEntity<Object> getViagemByDestino(@PathVariable(value = "id") Long id) {
        DestinoModel destino = destinoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Destino não encontrado!"));

        List<ViagemModel> viagens = viagemRepository.findAllByDestino(destino);

        return ResponseEntity.status(HttpStatus.OK).body(viagens);
    }
}
