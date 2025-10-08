package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.InventarioDao;
import com.mayadent.MAYADENTBD.entity.Inventario;
import com.mayadent.MAYADENTBD.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventarioDaoImpl implements InventarioDao {
    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public Inventario create(Inventario in) {
        return inventarioRepository.save(in);
    }

    @Override
    public Inventario update(Inventario in) {
        return inventarioRepository.save(in);
    }

    @Override
    public void delete(Inventario in) {
        inventarioRepository.delete(in);
    }

    @Override
    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }

    @Override
    public Inventario read(Long id) {
        return inventarioRepository.findById(id).get();
    }
}
