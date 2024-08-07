package com.aula.livro.controllers;

import com.aula.livro.repositories.LivroRepository;
import com.aula.livro.models.LivroModel;
import com.aula.livro.dtos.LivroRecordDto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<LivroModel>> getAllLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLivroById(@PathVariable(value = "id") UUID id) {
        Optional<LivroModel> productO = livroRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }

    @PostMapping
    public ResponseEntity<LivroModel> createLivro(@RequestBody @Valid LivroRecordDto livroRecordDto) {
        var livroModel = new LivroModel();
        BeanUtils.copyProperties(livroRecordDto, livroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livroModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLivro(@PathVariable(value = "id") UUID id) {
        Optional<LivroModel> productO = livroRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }

        livroRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Livro excluido com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLivro(@PathVariable(value = "id") UUID id, @RequestBody @Valid LivroRecordDto livroRecordDto) {
        Optional<LivroModel> productO = livroRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }

        var livroModel = productO.get();
        BeanUtils.copyProperties(livroRecordDto, livroModel);
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(livroModel));
    }
}
