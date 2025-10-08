package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.HistoriaClinica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HistoriaClinicaDao {
    HistoriaClinica create(HistoriaClinica hc);
    HistoriaClinica update(HistoriaClinica hc);
    void delete(HistoriaClinica hc);
    HistoriaClinica read(Long id);
    List<HistoriaClinica> readAll();
}
