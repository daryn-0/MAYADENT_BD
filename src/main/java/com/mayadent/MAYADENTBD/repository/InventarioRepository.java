package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.Inventario;
import com.mayadent.MAYADENTBD.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    List<Inventario> findAllByCantidad(int cantidad);
}
