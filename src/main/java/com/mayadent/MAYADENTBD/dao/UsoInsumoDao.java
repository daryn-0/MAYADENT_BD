package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.UsoInsumos;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UsoInsumoDao {
    UsoInsumos create(UsoInsumos ui);
    Optional<UsoInsumos> read(Long id);
    UsoInsumos update(UsoInsumos ui);
    void delete(Long id);
    List<UsoInsumos> readAll();
}
