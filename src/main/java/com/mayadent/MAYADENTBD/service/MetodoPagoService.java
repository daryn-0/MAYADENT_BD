package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.MetodoPago;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MetodoPagoService {
    MetodoPago create(MetodoPago mp);
    MetodoPago update(MetodoPago mp);
    void delete(MetodoPago mp);
    MetodoPago read(Long id);
    List<MetodoPago> readAll();
}
