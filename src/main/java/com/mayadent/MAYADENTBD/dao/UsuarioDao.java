package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UsuarioDao {
    Usuario create(Usuario u);
    Optional<Usuario> read(Long id);
    Usuario update(Usuario u);
    void delete(Long id);
    List<Usuario> readAll();
}
