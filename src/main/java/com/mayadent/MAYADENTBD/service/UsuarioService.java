package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UsuarioService {
    Usuario create(Usuario u);
    Usuario find(Long id);
    Usuario update(Usuario u);
    void delete(Usuario u);
    List<Usuario> findAll();
}
