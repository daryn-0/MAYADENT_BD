package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Tratamiento;
import com.mayadent.MAYADENTBD.service.TratamientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tratamientos")
@CrossOrigin(origins = "http://localhost:4200")

public class TratamientoController {
    @Autowired
    private TratamientoService tratamientoService;
    @GetMapping
    public ResponseEntity<List<Tratamiento>> readAll() {
        try {
            List<Tratamiento> tratamientos = tratamientoService.readAll();
            if (tratamientos.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(tratamientos, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Tratamiento> crearUsuario(@Valid @RequestBody Tratamiento t) {
        try {
            Tratamiento tratamiento = tratamientoService.create(t);
            return new ResponseEntity<>(tratamiento, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tratamiento> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Tratamiento tratamiento = tratamientoService.read(id).get();
            return new ResponseEntity<>(tratamiento, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tratamiento> delUsuario(@PathVariable("id") Long id) {
        try {
            tratamientoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Tratamiento t) {
        Optional<Tratamiento> tratamiento = tratamientoService.read(id);
        if (tratamiento.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tratamientoService.update(t), HttpStatus.OK);

        }
    }
}
