package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Cita;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CitaDao {
    Cita create(Cita c);
    Cita update(Cita c);
    Optional<Cita> read(Long id);
    void delete(Long id);
    List<Cita> readAll();
    List<Cita> findByDniPaciente(String dni);
}
