package com.example.viagens.repositories;

import com.example.viagens.models.DestinoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<DestinoModel, Long> {
}
