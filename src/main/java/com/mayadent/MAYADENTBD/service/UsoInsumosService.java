package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.UsoInsumos;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UsoInsumosService {
    UsoInsumos create(UsoInsumos ui);
    UsoInsumos read(Long id);
    UsoInsumos update(UsoInsumos ui);
    void delete(UsoInsumos ui);
    List<UsoInsumos> readAll();
}
