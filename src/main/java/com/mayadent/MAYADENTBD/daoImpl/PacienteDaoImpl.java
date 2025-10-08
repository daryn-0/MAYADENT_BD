package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.PacienteDao;
import com.mayadent.MAYADENTBD.entity.Paciente;
import com.mayadent.MAYADENTBD.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteDaoImpl implements PacienteDao {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente create(Paciente p) {
        return pacienteRepository.save(p);
    }

    @Override
    public Paciente update(Paciente p) {
        return pacienteRepository.save(p);
    }

    @Override
    public void delete(Paciente p) {
        pacienteRepository.delete(p);
    }

    @Override
    public Paciente read(Long id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    public List<Paciente> readAll() {
        return pacienteRepository.findAll();
    }
}
