package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.entity.EstadoPago;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EstadoPagoService {
    EstadoPago create(EstadoPago ep);
    EstadoPago update(EstadoPago ep);
    void delete(EstadoPago ep);
    EstadoPago read(Long id);
    List<EstadoPago> readAll();
}
