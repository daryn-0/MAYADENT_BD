package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.EstadoPago;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EstadoPagoDao {
    EstadoPago create(EstadoPago ep);
    EstadoPago update(EstadoPago ep);
    void delete(EstadoPago ep);
    EstadoPago read(Long id);
    List<EstadoPago> readAll();
}
