package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Cita_Tratamiento;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CitaTratamientoService {
    Cita_Tratamiento create (Cita_Tratamiento ct);
    Cita_Tratamiento update (Cita_Tratamiento ct);
    void delete (Cita_Tratamiento ct);
    Cita_Tratamiento read(Long id);
    List<Cita_Tratamiento> readAll();
}
