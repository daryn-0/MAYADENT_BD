package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.UsoInsumoDao;
import com.mayadent.MAYADENTBD.entity.UsoInsumos;
import com.mayadent.MAYADENTBD.repository.UsoInsumosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsoInsumosDaoImpl implements UsoInsumoDao{
    @Autowired
    private UsoInsumosRepository repo;
    @Override
    public UsoInsumos create(UsoInsumos ui) {
        return repo.save(ui);
    }

    @Override
    public Optional<UsoInsumos> read(Long id) {
        return repo.findById(id);
    }

    @Override
    public UsoInsumos update(UsoInsumos ui) {
        return repo.save(ui);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<UsoInsumos> readAll() {
        return repo.findAll();
    }
}
