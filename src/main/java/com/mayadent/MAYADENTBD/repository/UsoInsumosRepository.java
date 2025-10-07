package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.UsoInsumos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsoInsumosRepository extends JpaRepository<UsoInsumos, Integer> {
}
