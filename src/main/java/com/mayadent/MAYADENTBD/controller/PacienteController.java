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
            if (pa.getEstado() == null || pa.getEstado().trim().isEmpty()) {
                pa.setEstado("Activo");
            }

            Paciente paciente = pacienteService.create(pa);
            return new ResponseEntity<>(paciente, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear paciente: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Paciente> getPacienteByDni(@PathVariable("dni") String dni) {
        try {
            Optional<Paciente> paciente = pacienteService.findByDni(dni);
            if (paciente.isPresent()) {
                return new ResponseEntity<>(paciente.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Paciente>> getPacientesPorEstado(@PathVariable("estado") String estado) {
        try {
            List<Paciente> pacientes = pacienteService.findByEstado(estado);
            if (pacientes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(pacientes, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.err.println("Error al buscar pacientes por estado: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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

    @PutMapping("/actualizar/{dni}")
    public ResponseEntity<Paciente> updateUsuarioPorDni(@PathVariable("dni") String dni, @Valid @RequestBody Paciente pa) {
        try {
            Optional<Paciente> pacienteOpt = pacienteService.findByDni(dni);

            if (pacienteOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Paciente pacienteExistente = pacienteOpt.get();

            pacienteExistente.setNombre(pa.getNombre());
            pacienteExistente.setApellido(pa.getApellido());
            pacienteExistente.setCorreo(pa.getCorreo());
            pacienteExistente.setDni(pa.getDni());
            pacienteExistente.setTelefono(pa.getTelefono());
            pacienteExistente.setDireccion(pa.getDireccion());
            pacienteExistente.setEstado(pa.getEstado());

            Paciente actualizado = pacienteService.update(pacienteExistente);

            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Error al actualizar paciente con DNI " + dni + ": " + e.getMessage());
            e.printStackTrace();
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

    @PutMapping("/desactivar/{dni}")
    public ResponseEntity<Paciente> desactivarPorDni(@PathVariable("dni") String dni) {
        try {
            Optional<Paciente> pacienteOpt = pacienteService.findByDni(dni);
            if (pacienteOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Paciente paciente = pacienteOpt.get();
            paciente.setEstado("Inactivo");
            Paciente actualizado = pacienteService.update(paciente);

            System.out.println("Paciente con DNI " + dni + " marcado como Inactivo.");

            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Error al desactivar paciente con DNI: " + dni);
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
