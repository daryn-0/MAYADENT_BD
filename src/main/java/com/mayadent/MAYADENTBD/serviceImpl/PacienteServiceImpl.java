package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.PacienteDao;
import com.mayadent.MAYADENTBD.entity.Paciente;
import com.mayadent.MAYADENTBD.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteDao pacienteDao;

    @Override
    public Paciente create(Paciente p) {
        return pacienteDao.create(p);
    }

    @Override
    public Paciente update(Paciente p) {
        return pacienteDao.update(p);
    }

    @Override
    public void delete(Paciente p) {
        pacienteDao.delete(p);
    }

    @Override
    public Paciente read(Long id) {
        return pacienteDao.read(id);
    }

    @Override
    public List<Paciente> readAll() {
        return pacienteDao.readAll();
    }
}
