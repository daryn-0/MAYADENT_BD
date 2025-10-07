package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.Cita_Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaTratamientoRepository extends JpaRepository<Cita_Tratamiento, Long> {
}
