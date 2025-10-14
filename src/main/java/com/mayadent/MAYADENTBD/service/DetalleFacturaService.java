package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.DetalleFactura;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DetalleFacturaService {
    DetalleFactura create(DetalleFactura df);
    Optional<DetalleFactura> read(Long id);
    DetalleFactura update(DetalleFactura df);
    void delete(Long id);
    List<DetalleFactura> readAll();
}
