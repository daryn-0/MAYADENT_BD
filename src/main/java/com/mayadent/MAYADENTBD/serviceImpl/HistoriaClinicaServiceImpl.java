package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.HistoriaClinicaDao;
import com.mayadent.MAYADENTBD.entity.HistoriaClinica;
import com.mayadent.MAYADENTBD.service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {
    @Autowired
    private HistoriaClinicaDao historiaClinicaDao;

    @Override
    public HistoriaClinica create(HistoriaClinica hc) {
        return historiaClinicaDao.create(hc);
    }

    @Override
    public HistoriaClinica update(HistoriaClinica hc) {
        return historiaClinicaDao.update(hc);
    }

    @Override
    public void delete(Long id) {
        historiaClinicaDao.delete(id);
    }

    @Override
    public Optional<HistoriaClinica> read(Long id) {
        return historiaClinicaDao.read(id);
    }

    @Override
    public List<HistoriaClinica> readAll() {
        return historiaClinicaDao.readAll();
    }
}
