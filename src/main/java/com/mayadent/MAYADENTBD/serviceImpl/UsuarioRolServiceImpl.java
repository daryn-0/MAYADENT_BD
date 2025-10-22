package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.UsuarioRolDao;
import com.mayadent.MAYADENTBD.entity.Rol;
import com.mayadent.MAYADENTBD.entity.Usuario;
import com.mayadent.MAYADENTBD.entity.UsuarioRol;
import com.mayadent.MAYADENTBD.repository.RolRepository;
import com.mayadent.MAYADENTBD.repository.UsuarioRepository;
import com.mayadent.MAYADENTBD.repository.UsuarioRolRepository;
import com.mayadent.MAYADENTBD.service.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {
    @Autowired
    private UsuarioRolDao usuarioRolDao;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

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
