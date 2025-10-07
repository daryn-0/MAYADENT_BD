package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.EstadoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPagoRepository extends JpaRepository<EstadoPago, Long> {
}
