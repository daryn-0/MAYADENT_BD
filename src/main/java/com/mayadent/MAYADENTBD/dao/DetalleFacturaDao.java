package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.DetalleFactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DetalleFacturaDao {
    DetalleFactura create(DetalleFactura df);
    DetalleFactura read(Long id);
    DetalleFactura update(DetalleFactura df);
    void delete(DetalleFactura df);
    List<DetalleFactura> readAll();
}
