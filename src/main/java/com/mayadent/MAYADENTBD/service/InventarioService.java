package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Inventario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InventarioService {
    Inventario create(Inventario in);
    Inventario update(Inventario in);
    void delete(Long id);
    List<Inventario> readAll();
    Optional<Inventario> read(Long id);
}
