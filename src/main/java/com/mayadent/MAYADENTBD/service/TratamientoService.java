package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Tratamiento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TratamientoService {
    Tratamiento create(Tratamiento t);
    Optional<Tratamiento> read(Long id);
    Tratamiento update(Tratamiento t);
    void delete(Long id);
    List<Tratamiento> readAll();
}
