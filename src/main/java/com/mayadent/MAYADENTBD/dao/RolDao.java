package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Rol;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface RolDao {
    Rol create(Rol r);
    Optional<Rol> read(Long id);
    Rol update(Rol r);
    void delete(Long id);
    List<Rol> readAll();
}
