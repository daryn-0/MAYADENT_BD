package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Inventario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface InventarioDao {
    Inventario create(Inventario in);
    Inventario update(Inventario in);
    void delete(Long id);
    List<Inventario> readAll();
    Optional<Inventario> read(Long id);
}
