package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Inventario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InventarioDao {
    Inventario create(Inventario in);
    Inventario update(Inventario in);
    void delete(Inventario in);
    List<Inventario> findAll();
    Inventario read(Long id);
}
