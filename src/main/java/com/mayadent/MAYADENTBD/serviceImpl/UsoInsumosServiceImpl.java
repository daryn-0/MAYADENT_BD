package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.UsoInsumoDao;
import com.mayadent.MAYADENTBD.entity.UsoInsumos;
import com.mayadent.MAYADENTBD.service.UsoInsumosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsoInsumosServiceImpl implements UsoInsumosService {
    @Autowired
    private UsoInsumoDao usoInsumoDao;

    @Override
    public UsoInsumos create(UsoInsumos ui) {
        return usoInsumoDao.create(ui);
    }

    @Override
    public Optional<UsoInsumos> read(Long id) {
        return usoInsumoDao.read(id);
    }

    @Override
    public UsoInsumos update(UsoInsumos ui) {
        return usoInsumoDao.update(ui);
    }

    @Override
    public void delete(Long id) {
        usoInsumoDao.delete(id);
    }

    @Override
    public List<UsoInsumos> readAll() {
        return usoInsumoDao.readAll();
    }
}
