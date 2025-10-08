package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Tratamiento;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TratamientoService {
    Tratamiento create(Tratamiento t);
    Tratamiento read(Long id);
    Tratamiento update(Tratamiento t);
    void delete(Tratamiento t);
    List<Tratamiento> readAll();
}
