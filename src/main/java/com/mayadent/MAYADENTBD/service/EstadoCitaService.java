package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.EstadoCita;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EstadoCitaService {
    EstadoCita create(EstadoCita ec);
    EstadoCita read(Long id);
    EstadoCita update(EstadoCita ec);
    void delete(EstadoCita ec);
    List<EstadoCita> readAll();
}
