package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.UsuarioRolDao;
import com.mayadent.MAYADENTBD.entity.UsuarioRol;
import com.mayadent.MAYADENTBD.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioRolDaoImpl implements UsuarioRolDao {
    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    public UsuarioRol create(UsuarioRol ur) {
        return usuarioRolRepository.save(ur);
    }

    @Override
    public Optional<UsuarioRol> read(Long id) {
        return usuarioRolRepository.findById(id);
    }

    @Override
    public UsuarioRol update(UsuarioRol ur) {
        return usuarioRolRepository.save(ur);
    }

    @Override
    public void delete(Long id) {
        usuarioRolRepository.deleteById(id);
    }

    @Override
    public List<UsuarioRol> readAll() {
        return usuarioRolRepository.findAll();
    }
}
