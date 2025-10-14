package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.UsuarioDao;
import com.mayadent.MAYADENTBD.entity.Usuario;
import com.mayadent.MAYADENTBD.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario create(Usuario u) {
        return usuarioDao.create(u);
    }

    @Override
    public Optional<Usuario> read(Long id) {
        return usuarioDao.read(id);
    }

    @Override
    public Usuario update(Usuario u) {
        return usuarioDao.update(u);
    }

    @Override
    public void delete(Long id) {
        usuarioDao.delete(id);
    }

    @Override
    public List<Usuario> readAll() {
        return usuarioDao.readAll();
    }
}
