package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.MetodoPago;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface MetodoPagoDao {
    MetodoPago create(MetodoPago mp);
    MetodoPago update(MetodoPago mp);
    void delete(Long id);
    Optional<MetodoPago> read(Long id);
    List<MetodoPago> readAll();
}
