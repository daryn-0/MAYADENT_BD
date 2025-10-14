package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {
    Usuario create(Usuario u);
    Optional<Usuario> read(Long id);
    Usuario update(Usuario u);
    void delete(Long id);
    List<Usuario> readAll();
}
