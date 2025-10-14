package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.EstadoPago;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EstadoPagoService {
    EstadoPago create(EstadoPago ep);
    EstadoPago update(EstadoPago ep);
    void delete(Long id);
    Optional<EstadoPago> read(Long id);
    List<EstadoPago> readAll();
}
