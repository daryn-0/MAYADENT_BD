package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.entity.Paciente;
import com.mayadent.MAYADENTBD.service.CitaService;
import com.mayadent.MAYADENTBD.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaController {
    private static final Logger logger = LoggerFactory.getLogger(PacienteController.class);

    @Autowired
    private CitaService citaService;

    @GetMapping
    public ResponseEntity<List<Cita>> readAll() {
        try {
            List<Cita> citas = citaService.readAll();
            if (citas.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(citas, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Cita> crearUsuario(@Valid @RequestBody Cita ci) {
        try {
            Cita cita = citaService.create(ci);
            return new ResponseEntity<>(cita, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error al crear paciente: ", e);
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<List<Cita>> getCitasByDni(@PathVariable("dni") String dni) {
        List<Cita> citas = citaService.findByDniPaciente(dni);
        if (citas.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(citas);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Cita cita = citaService.read(id).get();
            return new ResponseEntity<>(cita, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cita> delUsuario(@PathVariable("id") Long id) {
        try {
            citaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Cita ci) {
        Optional<Cita> cita = citaService.read(id);
        if (cita.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(citaService.update(ci), HttpStatus.OK);

        }
    }
}
