package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Factura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FacturaDao {
    Factura create(Factura f);
    Factura update(Factura f);
    void delete(Factura f);
    Factura read(Long id);
    List<Factura> readAll();
}
