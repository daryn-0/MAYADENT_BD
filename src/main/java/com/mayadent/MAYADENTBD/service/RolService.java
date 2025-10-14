package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Rol;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RolService {
    Rol create(Rol r);
    Optional<Rol> read(Long id);
    Rol update(Rol r);
    void delete(Long id);
    List<Rol> readAll();
}
