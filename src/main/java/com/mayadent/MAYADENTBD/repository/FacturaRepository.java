package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
