package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.EstadoPagoDao;
import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.entity.EstadoPago;
import com.mayadent.MAYADENTBD.repository.EstadoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstadoPagoDaoImpl implements EstadoPagoDao {
    @Autowired
    private EstadoPagoRepository estadoPagoRepository;

    @Override
    public EstadoPago create(EstadoPago ep) {
        return estadoPagoRepository.save(ep);
    }

    @Override
    public EstadoPago update(EstadoPago ep) {
        return estadoPagoRepository.save(ep);
    }

    @Override
    public void delete(Long id) {
        estadoPagoRepository.deleteById(id);
    }

    @Override
    public Optional<EstadoPago> read(Long id) {
        return estadoPagoRepository.findById(id);
    }

    @Override
    public List<EstadoPago> readAll() {
        return estadoPagoRepository.findAll();
    }
}
