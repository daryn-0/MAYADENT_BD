package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.EstadoCitaDao;
import com.mayadent.MAYADENTBD.entity.EstadoCita;
import com.mayadent.MAYADENTBD.service.EstadoCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCitaServiceImpl implements EstadoCitaService {
    @Autowired
    private EstadoCitaDao estadoCitaDao;

    @Override
    public EstadoCita create(EstadoCita ec) {
        return estadoCitaDao.create(ec);
    }

    @Override
    public EstadoCita read(Long id) {
        return estadoCitaDao.read(id);
    }

    @Override
    public EstadoCita update(EstadoCita ec) {
        return estadoCitaDao.update(ec);
    }

    @Override
    public void delete(EstadoCita ec) {
        estadoCitaDao.delete(ec);
    }

    @Override
    public List<EstadoCita> readAll() {
        return estadoCitaDao.readAll();
    }
}
