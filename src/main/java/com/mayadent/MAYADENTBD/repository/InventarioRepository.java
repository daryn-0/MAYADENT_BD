package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}
