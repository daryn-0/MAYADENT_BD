package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Paciente;
import com.mayadent.MAYADENTBD.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "http://localhost:4200")

public class PacienteController {
    @Autowired
    private PacienteService pacienteService;
    @GetMapping
    public ResponseEntity<List<Paciente>> readAll() {
        try {
            List<Paciente> pacientes = pacienteService.readAll();
            if (pacientes.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(pacientes, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Paciente> crearUsuario(@Valid @RequestBody Paciente pa) {
        try {
            Paciente paciente = pacienteService.create(pa);
            return new ResponseEntity<>(paciente, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Paciente> getPacienteByDni(@PathVariable("dni") String dni) {
        try {
            Optional<Paciente> paciente = pacienteService.findByDni(dni);  // Buscar por DNI
            if (paciente.isPresent()) {
                return new ResponseEntity<>(paciente.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // No se encontró el paciente
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  // Manejo de excepciones
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Paciente paciente = pacienteService.read(id).get();
            return new ResponseEntity<>(paciente, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> delUsuario(@PathVariable("id") Long id) {
        try {
            pacienteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Paciente pa) {
        Optional<Paciente> paciente = pacienteService.read(id);
        if (paciente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(pacienteService.update(pa), HttpStatus.OK);

        }
    }
}
