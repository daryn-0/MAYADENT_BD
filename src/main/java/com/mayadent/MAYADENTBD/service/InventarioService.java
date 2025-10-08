package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Inventario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface InventarioService {
    Inventario create(Inventario in);
    Inventario update(Inventario in);
    void delete(Inventario in);
    List<Inventario> findAll();
    Inventario read(Long id);
}
