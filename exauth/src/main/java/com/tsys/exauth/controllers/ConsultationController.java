package com.tsys.exauth.controllers;

import com.tsys.exauth.domain.consultation.Consultation;
import com.tsys.exauth.domain.consultation.ConsultationDTO;
import com.tsys.exauth.repositories.ConsultationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("consultation")
public class ConsultationController {

    @Autowired
    ConsultationRepository consultationRepository;

    @GetMapping()
    public ResponseEntity<List<Consultation>> getConsultations(){
        return ResponseEntity.ok().body(consultationRepository.findAll());
    }

    @PostMapping()
    public ResponseEntity<Consultation> createConsultation(@RequestBody @Valid ConsultationDTO consultationDTO){
        Consultation consultationModel = new Consultation();
        BeanUtils.copyProperties(consultationDTO, consultationModel);

        return ResponseEntity.status(HttpStatus.FOUND).body(consultationRepository.save(consultationModel));
    }
}
