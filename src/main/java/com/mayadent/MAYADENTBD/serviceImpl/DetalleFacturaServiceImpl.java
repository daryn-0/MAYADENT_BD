package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.DetalleFacturaDao;
import com.mayadent.MAYADENTBD.entity.DetalleFactura;
import com.mayadent.MAYADENTBD.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {
    @Autowired
    private DetalleFacturaDao detalleFacturaDao;

    @Override
    public DetalleFactura create(DetalleFactura df) {
        return detalleFacturaDao.create(df);
    }

    @Override
    public DetalleFactura read(Long id) {
        return detalleFacturaDao.read(id);
    }

    @Override
    public DetalleFactura update(DetalleFactura df) {
        return detalleFacturaDao.update(df);
    }

    @Override
    public void delete(DetalleFactura df) {
        detalleFacturaDao.delete(df);
    }

    @Override
    public List<DetalleFactura> readAll() {
        return detalleFacturaDao.readAll();
    }
}
