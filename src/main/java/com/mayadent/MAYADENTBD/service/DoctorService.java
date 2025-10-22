package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface DoctorService {
    Doctor create(Doctor doctor);
    Doctor update(Doctor doctor);
    void delete(long id);
    Optional<Doctor> read(long id);
    List<Doctor> readAll();
}
