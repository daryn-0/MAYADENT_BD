package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Cita;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CitaService {
    Cita create(Cita c);
    Cita update(Cita c);
    Cita read(Long id);
    void delete(Long id);
    List<Cita> readAll();
}
