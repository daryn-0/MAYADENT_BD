package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.UsoInsumos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsoInsumosService {
    UsoInsumos create(UsoInsumos ui);
    Optional<UsoInsumos> read(Long id);
    UsoInsumos update(UsoInsumos ui);
    void delete(Long id);
    List<UsoInsumos> readAll();
}
