package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Cita_Tratamiento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CitaTratamientoDao {
    Cita_Tratamiento create (Cita_Tratamiento ct);
    Cita_Tratamiento update (Cita_Tratamiento ct);
    void delete (Long id);
    Optional<Cita_Tratamiento> read (Long id);
    List<Cita_Tratamiento> findAll ();
}
