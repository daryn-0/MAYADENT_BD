package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.MetodoPago;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MetodoPagoService {
    MetodoPago create(MetodoPago mp);
    MetodoPago update(MetodoPago mp);
    void delete(Long id);
    Optional<MetodoPago> read(Long id);
    List<MetodoPago> readAll();
}
