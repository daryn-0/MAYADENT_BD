package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {
}
