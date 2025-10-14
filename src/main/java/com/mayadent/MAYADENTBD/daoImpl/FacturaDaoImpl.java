package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.FacturaDao;
import com.mayadent.MAYADENTBD.entity.Factura;
import com.mayadent.MAYADENTBD.repository.FacturaRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FacturaDaoImpl implements FacturaDao {
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public Factura create(Factura f) {
        return facturaRepository.save(f);
    }

    @Override
    public Factura update(Factura f) {
        return facturaRepository.save(f);
    }

    @Override
    public void delete(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public Optional<Factura> read(Long id) {
        return facturaRepository.findById(id);
    }

    @Override
    public List<Factura> readAll() {
        return facturaRepository.findAll();
    }
}
