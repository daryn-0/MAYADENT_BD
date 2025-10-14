package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.MetodoPagoDao;
import com.mayadent.MAYADENTBD.entity.MetodoPago;
import com.mayadent.MAYADENTBD.repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MetodoPagoDaoImpl implements MetodoPagoDao {
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public MetodoPago create(MetodoPago mp) {
        return metodoPagoRepository.save(mp);
    }

    @Override
    public MetodoPago update(MetodoPago mp) {
        return metodoPagoRepository.save(mp);
    }

    @Override
    public void delete(Long id) {
        metodoPagoRepository.deleteById(id);
    }

    @Override
    public Optional<MetodoPago> read(Long id) {
        return metodoPagoRepository.findById(id);
    }

    @Override
    public List<MetodoPago> readAll() {
        return metodoPagoRepository.findAll();
    }
}
