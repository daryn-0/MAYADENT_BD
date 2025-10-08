package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Rol;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RolService {
    Rol create(Rol r);
    Rol read(Long id);
    Rol update(Rol r);
    void delete(Long id);
    List<Rol> readAll();
}
