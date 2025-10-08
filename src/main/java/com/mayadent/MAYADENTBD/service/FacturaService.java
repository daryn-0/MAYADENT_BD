package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Factura;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FacturaService {
    Factura create(Factura f);
    Factura update(Factura f);
    void delete(Factura f);
    Factura read(Long id);
    List<Factura> readAll();
}
