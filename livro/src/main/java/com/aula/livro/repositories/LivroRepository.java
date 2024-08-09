package com.aula.livro.repositories;

import com.aula.livro.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, UUID> {
    List<LivroModel> findAllByGenre(String genre);
}
