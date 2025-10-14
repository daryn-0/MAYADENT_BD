package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Tratamiento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TratamientoDao {
    Tratamiento create(Tratamiento t);
    Optional<Tratamiento> read(Long id);
    Tratamiento update(Tratamiento t);
    void delete(Long id);
    List<Tratamiento> readAll();
}
