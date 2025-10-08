package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Cita;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CitaDao {
    Cita create(Cita c);
    Cita update(Cita c);
    Cita read(Long id);
    void delete(Long id);
    List<Cita> readAll();
}
