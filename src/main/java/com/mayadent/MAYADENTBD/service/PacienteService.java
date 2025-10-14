package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PacienteService {
    Paciente create(Paciente p);
    Paciente update(Paciente p);
    void delete(Long id);
    Optional<Paciente> read(Long id);
    List<Paciente> readAll();
}
