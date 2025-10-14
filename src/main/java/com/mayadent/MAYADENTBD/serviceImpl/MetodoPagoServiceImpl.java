package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.MetodoPagoDao;
import com.mayadent.MAYADENTBD.entity.MetodoPago;
import com.mayadent.MAYADENTBD.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {
    @Autowired
    private MetodoPagoDao metodoPagoDao;

    @Override
    public MetodoPago create(MetodoPago mp) {
        return metodoPagoDao.create(mp);
    }

    @Override
    public MetodoPago update(MetodoPago mp) {
        return metodoPagoDao.update(mp);
    }

    @Override
    public void delete(Long id) {
        metodoPagoDao.delete(id);
    }

    @Override
    public Optional<MetodoPago> read(Long id) {
        return metodoPagoDao.read(id);
    }

    @Override
    public List<MetodoPago> readAll() {
        return metodoPagoDao.readAll();
    }
}
