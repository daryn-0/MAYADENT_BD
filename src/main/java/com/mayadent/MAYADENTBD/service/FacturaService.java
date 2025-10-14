package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Factura;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FacturaService {
    Factura create(Factura f);
    Factura update(Factura f);
    void delete(Long id);
    Optional<Factura> read(Long id);
    List<Factura> readAll();
}
