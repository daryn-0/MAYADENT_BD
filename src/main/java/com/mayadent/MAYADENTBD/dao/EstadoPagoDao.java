package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.EstadoPago;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EstadoPagoDao {
    EstadoPago create(EstadoPago ep);
    EstadoPago update(EstadoPago ep);
    void delete(Long id);
    Optional<EstadoPago> read(Long id);
    List<EstadoPago> readAll();
}
