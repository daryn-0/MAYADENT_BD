package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.HistoriaClinica;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HistoriaClinicaService {
    HistoriaClinica create(HistoriaClinica hc);
    HistoriaClinica update(HistoriaClinica hc);
    void delete(Long id);
    Optional<HistoriaClinica> read(Long id);
    List<HistoriaClinica> readAll();
}
