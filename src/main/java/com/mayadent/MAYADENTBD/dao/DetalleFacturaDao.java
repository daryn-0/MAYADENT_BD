package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.DetalleFactura;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DetalleFacturaDao {
    DetalleFactura create(DetalleFactura df);
    Optional<DetalleFactura> read(Long id);
    DetalleFactura update(DetalleFactura df);
    void delete(Long id);
    List<DetalleFactura> readAll();
}
