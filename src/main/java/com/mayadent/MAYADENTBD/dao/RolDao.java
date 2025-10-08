package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Rol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RolDao {
    Rol create(Rol r);
    Rol read(Long id);
    Rol update(Rol r);
    void delete(Long id);
    List<Rol> readAll();
}
