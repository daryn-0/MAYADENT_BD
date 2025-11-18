package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.Cita_Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaTratamientoRepository extends JpaRepository<Cita_Tratamiento, Long> {
    @Query("SELECT ct FROM Cita_Tratamiento ct WHERE ct.cita.id = :citaId")
    List<Cita_Tratamiento> findByCitaId(@Param("citaId") Long citaId);
}
