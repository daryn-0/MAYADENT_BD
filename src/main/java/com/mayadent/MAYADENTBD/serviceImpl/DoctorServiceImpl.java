package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.DoctorDao;
import com.mayadent.MAYADENTBD.entity.Doctor;
import com.mayadent.MAYADENTBD.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;

    @Override
    public Doctor create(Doctor doctor) {
        return doctorDao.create(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return doctorDao.update(doctor);
    }

    @Override
    public void delete(long id) {
        doctorDao.delete(id);
    }

    @Override
    public Optional<Doctor> read(long id) {
        return doctorDao.read(id);
    }

    @Override
    public List<Doctor> readAll() {
        return doctorDao.readAll();
    }
}
