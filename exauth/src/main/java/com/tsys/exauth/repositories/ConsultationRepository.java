package com.tsys.exauth.repositories;

import com.tsys.exauth.domain.consultation.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, String> {

}
