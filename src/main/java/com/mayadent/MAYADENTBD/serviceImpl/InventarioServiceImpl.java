package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.InventarioDao;
import com.mayadent.MAYADENTBD.entity.Inventario;
import com.mayadent.MAYADENTBD.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void delete(Inventario in) {
        inventarioDao.delete(in);
    }

    @Override
    public List<Inventario> findAll() {
        return inventarioDao.findAll();
    }

    @Override
    public Inventario read(Long id) {
        return inventarioDao.read(id);
    }
}
