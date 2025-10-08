package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UsuarioDao {
    Usuario create(Usuario u);
    Usuario find(Long id);
    Usuario update(Usuario u);
    void delete(Usuario u);
    List<Usuario> findAll();
}
