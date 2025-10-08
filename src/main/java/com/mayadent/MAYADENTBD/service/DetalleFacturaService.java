package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.DetalleFactura;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DetalleFacturaService {
    DetalleFactura create(DetalleFactura df);
    DetalleFactura read(Long id);
    DetalleFactura update(DetalleFactura df);
    void delete(DetalleFactura df);
    List<DetalleFactura> readAll();
}
