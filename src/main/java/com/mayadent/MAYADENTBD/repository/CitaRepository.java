package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
