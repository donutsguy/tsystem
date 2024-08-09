package com.example.aula.primeiroprojeto.controller;

import com.example.aula.primeiroprojeto.dtos.CategoryRecordDto;
import com.example.aula.primeiroprojeto.dtos.ProductRecordDto;
import com.example.aula.primeiroprojeto.models.CategoryModel;
import com.example.aula.primeiroprojeto.models.ProductModel;
import com.example.aula.primeiroprojeto.repositories.CategoryRepository;
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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<CategoryModel>> getAllCategorys() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable(value = "id") UUID id) {
        Optional<CategoryModel> categoryO = categoryRepository.findById(id);
        if (categoryO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(categoryO.get());
    }

    @PostMapping
    public ResponseEntity<CategoryModel> createCategory(@RequestBody @Valid CategoryRecordDto categoryDto) {
        var categoryModel = new CategoryModel();
        BeanUtils.copyProperties(categoryDto, categoryModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(categoryModel));
    }

}
