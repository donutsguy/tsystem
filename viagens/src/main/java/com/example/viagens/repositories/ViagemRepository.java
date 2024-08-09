package com.example.viagens.repositories;

import com.example.viagens.models.DestinoModel;
import com.example.viagens.models.ViagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViagemRepository extends JpaRepository<ViagemModel, Long> {
    List<ViagemModel> findAllByDestino(DestinoModel destino);
}
