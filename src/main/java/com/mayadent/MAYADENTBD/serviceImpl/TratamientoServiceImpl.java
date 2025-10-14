package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.TratamientoDao;
import com.mayadent.MAYADENTBD.entity.Tratamiento;
import com.mayadent.MAYADENTBD.service.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TratamientoServiceImpl implements TratamientoService {
    @Autowired
    private TratamientoDao tratamientoDao;

    @Override
    public Tratamiento create(Tratamiento t) {
        return tratamientoDao.create(t);
    }

    @Override
    public Optional<Tratamiento> read(Long id) {
        return tratamientoDao.read(id);
    }

    @Override
    public Tratamiento update(Tratamiento t) {
        return tratamientoDao.update(t);
    }

    @Override
    public void delete(Long id) {
        tratamientoDao.delete(id);
    }

    @Override
    public List<Tratamiento> readAll() {
        return tratamientoDao.readAll();
    }
}
