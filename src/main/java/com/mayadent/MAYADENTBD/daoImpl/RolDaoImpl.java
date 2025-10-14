package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.RolDao;
import com.mayadent.MAYADENTBD.entity.Rol;
import com.mayadent.MAYADENTBD.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RolDaoImpl implements RolDao {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public Rol create(Rol r) {
        return rolRepository.save(r);
    }

    @Override
    public Optional<Rol> read(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol update(Rol r) {
        return rolRepository.save(r);
    }

    @Override
    public void delete(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public List<Rol> readAll() {
        return rolRepository.findAll();
    }
}
