package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.HistoriaClinica;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HistoriaClinicaService {
    HistoriaClinica create(HistoriaClinica hc);
    HistoriaClinica update(HistoriaClinica hc);
    void delete(HistoriaClinica hc);
    HistoriaClinica read(Long id);
    List<HistoriaClinica> readAll();
}
