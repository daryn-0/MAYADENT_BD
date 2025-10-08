package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.DetalleFacturaDao;
import com.mayadent.MAYADENTBD.entity.DetalleFactura;
import com.mayadent.MAYADENTBD.repository.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DetalleFacturaDaoImpl implements DetalleFacturaDao {
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public DetalleFactura create(DetalleFactura df) {
        return detalleFacturaRepository.save(df);
    }

    @Override
    public DetalleFactura read(Long id) {
        return detalleFacturaRepository.findById(id).get();
    }

    @Override
    public DetalleFactura update(DetalleFactura df) {
        return detalleFacturaRepository.save(df);
    }

    @Override
    public void delete(DetalleFactura df) {
        detalleFacturaRepository.delete(df);
    }

    @Override
    public List<DetalleFactura> readAll() {
        return detalleFacturaRepository.findAll();
    }
}
