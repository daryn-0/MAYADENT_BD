package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.EstadoCita;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EstadoCitaDao {
    EstadoCita create(EstadoCita ec);
    Optional<EstadoCita> read(Long id);
    EstadoCita update(EstadoCita ec);
    void delete(Long id);
    List<EstadoCita> readAll();
}
