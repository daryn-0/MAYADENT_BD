package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.EstadoCita;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EstadoCitaService {
    EstadoCita create(EstadoCita ec);
    Optional<EstadoCita> read(Long id);
    EstadoCita update(EstadoCita ec);
    void delete(Long id);
    List<EstadoCita> readAll();
}
