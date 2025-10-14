package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.FacturaDao;
import com.mayadent.MAYADENTBD.entity.Factura;
import com.mayadent.MAYADENTBD.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaDao facturaDao;

    @Override
    public Factura create(Factura f) {
        return facturaDao.create(f);
    }

    @Override
    public Factura update(Factura f) {
        return facturaDao.update(f);
    }

    @Override
    public void delete(Long id) {
        facturaDao.delete(id);
    }

    @Override
    public Optional<Factura> read(Long id) {
        return facturaDao.read(id);
    }

    @Override
    public List<Factura> readAll() {
        return facturaDao.readAll();
    }
}
