package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.UsuarioRol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UsuarioRolDao {
    UsuarioRol create(UsuarioRol ur);
    UsuarioRol read(Long id);
    UsuarioRol update(UsuarioRol ur);
    void delete(UsuarioRol ur);
    List<UsuarioRol> readAll();
}
