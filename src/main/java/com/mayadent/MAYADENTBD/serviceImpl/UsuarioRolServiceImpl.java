package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.UsuarioRolDao;
import com.mayadent.MAYADENTBD.entity.UsuarioRol;
import com.mayadent.MAYADENTBD.service.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {
    @Autowired
    private UsuarioRolDao usuarioRolDao;

    @Override
    public UsuarioRol create(UsuarioRol ur) {
        return usuarioRolDao.create(ur);
    }

    @Override
    public Optional<UsuarioRol> read(Long id) {
        return usuarioRolDao.read(id);
    }

    @Override
    public UsuarioRol update(UsuarioRol ur) {
        return usuarioRolDao.update(ur);
    }

    @Override
    public void delete(Long id) {
        usuarioRolDao.delete(id);
    }

    @Override
    public List<UsuarioRol> readAll() {
        return usuarioRolDao.readAll();
    }
}
