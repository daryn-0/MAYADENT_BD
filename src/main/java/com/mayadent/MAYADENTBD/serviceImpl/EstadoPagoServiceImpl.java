package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.EstadoPagoDao;
import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.entity.EstadoPago;
import com.mayadent.MAYADENTBD.service.EstadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoPagoServiceImpl implements EstadoPagoService {
    @Autowired
    private EstadoPagoDao estadoPagoDao;

    @Override
    public EstadoPago create(EstadoPago ep) {
        return estadoPagoDao.create(ep);
    }

    @Override
    public EstadoPago update(EstadoPago ep) {
        return estadoPagoDao.update(ep);
    }

    @Override
    public void delete(EstadoPago ep) {
        estadoPagoDao.delete(ep);
    }

    @Override
    public EstadoPago read(Long id) {
        return estadoPagoDao.read(id);
    }

    @Override
    public List<EstadoPago> readAll() {
        return estadoPagoDao.readAll();
    }
}
