package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.EstadoCita;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EstadoCitaDao {
    EstadoCita create(EstadoCita ec);
    EstadoCita read(Long id);
    EstadoCita update(EstadoCita ec);
    void delete(EstadoCita ec);
    List<EstadoCita> readAll();
}
