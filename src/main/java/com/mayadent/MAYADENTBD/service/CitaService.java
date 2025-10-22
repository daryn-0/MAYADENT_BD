package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Cita;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CitaService {
    Cita create(Cita c);
    Cita update(Cita c);
    Optional<Cita> read(Long id);
    void delete(Long id);
    List<Cita> readAll();
    List<Cita> findByDniPaciente(String dni);
}
