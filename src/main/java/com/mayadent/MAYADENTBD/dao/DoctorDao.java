package com.mayadent.MAYADENTBD.dao;

import com.mayadent.MAYADENTBD.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorDao {
    Doctor create(Doctor doctor);
    Doctor update(Doctor doctor);
    Optional<Doctor> read(Long id);
    void delete(Long id);
    List<Doctor> readAll();
}
