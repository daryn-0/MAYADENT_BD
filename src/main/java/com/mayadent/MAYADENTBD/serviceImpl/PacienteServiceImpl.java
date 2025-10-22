package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.PacienteDao;
import com.mayadent.MAYADENTBD.entity.Paciente;
import com.mayadent.MAYADENTBD.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void delete(Long id) {
        pacienteDao.delete(id);
    }

    @Override
    public Optional<Paciente> read(Long id) {
        return pacienteDao.read(id);
    }

    @Override
    public List<Paciente> readAll() {
        return pacienteDao.readAll();
    }

    @Override
    public Optional<Paciente> findByDni(String dni) {
      return pacienteDao.findByDni(dni);
    }
}
