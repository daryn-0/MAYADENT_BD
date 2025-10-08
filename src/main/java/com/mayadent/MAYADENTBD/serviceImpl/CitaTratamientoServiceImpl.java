package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.CitaTratamientoDao;
import com.mayadent.MAYADENTBD.entity.Cita_Tratamiento;
import com.mayadent.MAYADENTBD.service.CitaTratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaTratamientoServiceImpl implements CitaTratamientoService {
    @Autowired
    private CitaTratamientoDao citaTratamientoDao;

    @Override
    public Cita_Tratamiento create(Cita_Tratamiento ct) {
        return citaTratamientoDao.create(ct);
    }

    @Override
    public Cita_Tratamiento update(Cita_Tratamiento ct) {
        return citaTratamientoDao.update(ct);
    }

    @Override
    public void delete(Cita_Tratamiento ct) {
        citaTratamientoDao.delete(ct);
    }

    @Override
    public Cita_Tratamiento read(Long id) {
        return citaTratamientoDao.read(id);
    }

    @Override
    public List<Cita_Tratamiento> readAll() {
        return citaTratamientoDao.findAll();
    }
}
