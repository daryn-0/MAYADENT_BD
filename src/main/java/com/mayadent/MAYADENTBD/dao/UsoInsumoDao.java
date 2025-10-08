package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.UsoInsumos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UsoInsumoDao {
    UsoInsumos create(UsoInsumos ui);
    UsoInsumos read(Long id);
    UsoInsumos update(UsoInsumos ui);
    void delete(UsoInsumos ui);
    List<UsoInsumos> readAll();
}
