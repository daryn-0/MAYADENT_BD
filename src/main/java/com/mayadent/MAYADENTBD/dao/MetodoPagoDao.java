package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.MetodoPago;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MetodoPagoDao {
    MetodoPago create(MetodoPago mp);
    MetodoPago update(MetodoPago mp);
    void delete(MetodoPago mp);
    MetodoPago read(Long id);
    List<MetodoPago> readAll();
}
