package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCitaRepository extends JpaRepository<EstadoCita, Long> {
}
