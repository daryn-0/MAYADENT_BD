package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.UsuarioRol;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioRolService {
    UsuarioRol create(UsuarioRol ur);
    Optional<UsuarioRol> read(Long id);
    UsuarioRol update(UsuarioRol ur);
    void delete(Long id);
    List<UsuarioRol> readAll();
}
