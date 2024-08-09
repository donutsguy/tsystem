package com.example.viagens.dtos;

import com.example.viagens.models.DestinoModel;

import java.time.LocalDate;

public record ViagemRecordDto(String titulo, LocalDate data_inicio, LocalDate data_final, Long destinoId) {
}
