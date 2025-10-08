package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.UsuarioRolDao;
import com.mayadent.MAYADENTBD.entity.UsuarioRol;
import com.mayadent.MAYADENTBD.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioRolDaoImpl implements UsuarioRolDao {
    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    public UsuarioRol create(UsuarioRol ur) {
        return usuarioRolRepository.save(ur);
    }

    @Override
    public UsuarioRol read(Long id) {
        return usuarioRolRepository.findById(id).get();
    }

    @Override
    public UsuarioRol update(UsuarioRol ur) {
        return usuarioRolRepository.save(ur);
    }

    @Override
    public void delete(UsuarioRol ur) {
        usuarioRolRepository.delete(ur);
    }

    @Override
    public List<UsuarioRol> readAll() {
        return usuarioRolRepository.findAll();
    }
}
