package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.HistoriaClinicaDao;
import com.mayadent.MAYADENTBD.entity.HistoriaClinica;
import com.mayadent.MAYADENTBD.repository.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HistoriaClinicaDaoImpl implements HistoriaClinicaDao {
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public HistoriaClinica create(HistoriaClinica hc) {
        return historiaClinicaRepository.save(hc);
    }

    @Override
    public HistoriaClinica update(HistoriaClinica hc) {
        return historiaClinicaRepository.save(hc);
    }

    @Override
    public void delete(Long id) {
        historiaClinicaRepository.deleteById(id);
    }

    @Override
    public Optional<HistoriaClinica> read(Long id) {
        return historiaClinicaRepository.findById(id);
    }

    @Override
    public List<HistoriaClinica> readAll() {
        return historiaClinicaRepository.findAll();
    }
}
