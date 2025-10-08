package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.TratamientoDao;
import com.mayadent.MAYADENTBD.entity.Tratamiento;
import com.mayadent.MAYADENTBD.repository.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TratamientoDaoImpl implements TratamientoDao {
    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public Tratamiento create(Tratamiento t) {
        return tratamientoRepository.save(t);
    }

    @Override
    public Tratamiento read(Long id) {
        return tratamientoRepository.findById(id).get();
    }

    @Override
    public Tratamiento update(Tratamiento t) {
        return tratamientoRepository.save(t);
    }

    @Override
    public void delete(Tratamiento t) {
        tratamientoRepository.delete(t);
    }

    @Override
    public List<Tratamiento> readAll() {
        return tratamientoRepository.findAll();
    }
}
