package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.CitaDao;
import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaDao citaDao;

    @Override
    public Cita create(Cita c) {
        return citaDao.create(c);
    }

    @Override
    public Cita update(Cita c) {
        return citaDao.update(c);
    }

    @Override
    public Cita read(Long id) {
        return citaDao.read(id);
    }

    @Override
    public void delete(Long id) {
        citaDao.delete(id);
    }

    @Override
    public List<Cita> readAll() {
        return citaDao.readAll();
    }
}
