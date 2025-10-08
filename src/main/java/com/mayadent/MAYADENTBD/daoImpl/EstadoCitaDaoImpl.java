package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.EstadoCitaDao;
import com.mayadent.MAYADENTBD.entity.EstadoCita;
import com.mayadent.MAYADENTBD.repository.EstadoCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstadoCitaDaoImpl implements EstadoCitaDao {
    @Autowired
    private EstadoCitaRepository estadoCitaRepository;

    @Override
    public EstadoCita create(EstadoCita ec) {
        return estadoCitaRepository.save(ec);
    }

    @Override
    public EstadoCita read(Long id) {
        return estadoCitaRepository.findById(id).get();
    }

    @Override
    public EstadoCita update(EstadoCita ec) {
        return estadoCitaRepository.save(ec);
    }

    @Override
    public void delete(EstadoCita ec) {
        estadoCitaRepository.delete(ec);
    }

    @Override
    public List<EstadoCita> readAll() {
        return estadoCitaRepository.findAll();
    }
}
