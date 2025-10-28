package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Paciente;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface
PacienteDao {
    Paciente create(Paciente p);
    Paciente update(Paciente p);
    void delete(Long id);
    Optional<Paciente> read(Long id);
    List<Paciente> readAll();
    Optional<Paciente> findByDni(String dni);
    List<Paciente> findByEstado(String estado);

}
