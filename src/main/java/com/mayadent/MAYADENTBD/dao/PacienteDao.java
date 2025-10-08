package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Paciente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PacienteDao {
    Paciente create(Paciente p);
    Paciente update(Paciente p);
    void delete(Paciente p);
    Paciente read(Long id);
    List<Paciente> readAll();
}
