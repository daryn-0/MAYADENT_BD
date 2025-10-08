package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.UsuarioRol;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UsuarioRolService {
    UsuarioRol create(UsuarioRol ur);
    UsuarioRol read(Long id);
    UsuarioRol update(UsuarioRol ur);
    void delete(UsuarioRol ur);
    List<UsuarioRol> readAll();
}
