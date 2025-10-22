package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Doctor;
import com.mayadent.MAYADENTBD.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctores")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping
    public ResponseEntity<List<Doctor>> readAll() {
        try {
            List<Doctor> doctors = doctorService.readAll();
            if (doctors.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(doctors, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Doctor> crearUsuario(@Valid @RequestBody Doctor d) {
        try {
            Doctor doctor = doctorService.create(d);
            return new ResponseEntity<>(doctor, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Doctor doctor = doctorService.read(id).get();
            return new ResponseEntity<>(doctor, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> delUsuario(@PathVariable("id") Long id) {
        try {
            doctorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Doctor d) {
        Optional<Doctor> doctor = doctorService.read(id);
        if (doctor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(doctorService.update(d), HttpStatus.OK);

        }
    }
}
