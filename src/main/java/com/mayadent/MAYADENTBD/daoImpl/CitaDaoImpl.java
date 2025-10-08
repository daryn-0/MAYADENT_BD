package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.CitaDao;
import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CitaDaoImpl implements CitaDao {
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public Cita create(Cita c) {
        return citaRepository.save(c);
    }

    @Override
    public Cita update(Cita c) {
        return citaRepository.save(c);
    }

    @Override
    public Cita read(Long id) {
        return citaRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        citaRepository.deleteById(id);
    }

    @Override
    public List<Cita> readAll() {
        return citaRepository.findAll();
    }
}
