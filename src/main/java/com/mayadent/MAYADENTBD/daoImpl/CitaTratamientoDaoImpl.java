package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.CitaTratamientoDao;
import com.mayadent.MAYADENTBD.entity.Cita_Tratamiento;
import com.mayadent.MAYADENTBD.repository.CitaTratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CitaTratamientoDaoImpl implements CitaTratamientoDao {
    @Autowired
    private CitaTratamientoRepository citaTratamientoRepository;

    @Override
    public Cita_Tratamiento create(Cita_Tratamiento ct) {
        return citaTratamientoRepository.save(ct);
    }

    @Override
    public Cita_Tratamiento update(Cita_Tratamiento ct) {
        return citaTratamientoRepository.save(ct);
    }

    @Override
    public void delete(Long id) {
        citaTratamientoRepository.deleteById(id);
    }

    @Override
    public Optional<Cita_Tratamiento> read(Long id) {
        return citaTratamientoRepository.findById(id);
    }

    @Override
    public List<Cita_Tratamiento> findAll() {
        return citaTratamientoRepository.findAll();
    }
}
