package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.InventarioDao;
import com.mayadent.MAYADENTBD.entity.Inventario;
import com.mayadent.MAYADENTBD.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {
    @Autowired
    private InventarioDao inventarioDao;

    @Override
    public Inventario create(Inventario in) {
        return inventarioDao.create(in);
    }

    @Override
    public Inventario update(Inventario in) {
        return inventarioDao.update(in);
    }

    @Override
    public void delete(Long id) {
        inventarioDao.delete(id);
    }

    @Override
    public List<Inventario> readAll() {
        return inventarioDao.readAll();
    }

    @Override
    public Optional<Inventario> read(Long id) {
        return inventarioDao.read(id);
    }
}
