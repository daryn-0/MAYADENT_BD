package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.UsuarioDao;
import com.mayadent.MAYADENTBD.entity.Usuario;
import com.mayadent.MAYADENTBD.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario create(Usuario u) {
        return usuarioDao.create(u);
    }

    @Override
    public Usuario find(Long id) {
        return usuarioDao.find(id);
    }

    @Override
    public Usuario update(Usuario u) {
        return usuarioDao.update(u);
    }

    @Override
    public void delete(Usuario u) {
        usuarioDao.delete(u);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }
}
