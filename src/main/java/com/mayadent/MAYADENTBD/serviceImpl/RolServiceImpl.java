package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.RolDao;
import com.mayadent.MAYADENTBD.entity.Rol;
import com.mayadent.MAYADENTBD.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolDao rolDao;

    @Override
    public Rol create(Rol r) {
        return rolDao.create(r);
    }

    @Override
    public Rol read(Long id) {
        return rolDao.read(id);
    }

    @Override
    public Rol update(Rol r) {
        return rolDao.update(r);
    }

    @Override
    public void delete(Long id) {
        rolDao.delete(id);
    }

    @Override
    public List<Rol> readAll() {
        return rolDao.readAll();
    }
}
