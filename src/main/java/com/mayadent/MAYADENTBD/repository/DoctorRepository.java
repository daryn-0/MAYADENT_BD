package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
