package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByPacienteDni(String dni);
    @Query("select c from Cita c where c.fecha_cita = :fecha")
    List<Cita> findByFecha_Cita(@Param("fecha") LocalDate fecha);
}
