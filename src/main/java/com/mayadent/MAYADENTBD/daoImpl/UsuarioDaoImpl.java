package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.UsuarioDao;
import com.mayadent.MAYADENTBD.entity.Usuario;
import com.mayadent.MAYADENTBD.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioDaoImpl implements UsuarioDao {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Usuario create(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public Usuario find(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario update(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public void delete(Usuario u) {
        usuarioRepository.delete(u);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
