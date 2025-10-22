package com.mayadent.MAYADENTBD.daoImpl;

import com.mayadent.MAYADENTBD.dao.DoctorDao;
import com.mayadent.MAYADENTBD.entity.Doctor;
import com.mayadent.MAYADENTBD.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class DoctorDaoImpl implements DoctorDao {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Optional<Doctor> read(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<Doctor> readAll() {
        return doctorRepository.findAll();
    }
}
