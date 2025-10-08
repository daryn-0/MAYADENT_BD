package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Tratamiento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TratamientoDao {
    Tratamiento create(Tratamiento t);
    Tratamiento read(Long id);
    Tratamiento update(Tratamiento t);
    void delete(Tratamiento t);
    List<Tratamiento> readAll();
}
