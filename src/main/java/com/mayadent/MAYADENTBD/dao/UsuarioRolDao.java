package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.UsuarioRol;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UsuarioRolDao {
    UsuarioRol create(UsuarioRol ur);
    Optional<UsuarioRol> read(Long id);
    UsuarioRol update(UsuarioRol ur);
    void delete(Long id);
    List<UsuarioRol> readAll();
}
