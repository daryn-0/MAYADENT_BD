package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.entity.Cita_Tratamiento;
import com.mayadent.MAYADENTBD.service.CitaService;
import com.mayadent.MAYADENTBD.service.CitaTratamientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citaTratamientos")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaTratamientoController {
    @Autowired
    private CitaTratamientoService citaTratamientoService;
    @GetMapping
    public ResponseEntity<List<Cita_Tratamiento>> readAll() {
        try {
            List<Cita_Tratamiento> citaTratamientos = citaTratamientoService.readAll();
            if (citaTratamientos.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(citaTratamientos, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Cita_Tratamiento> crearUsuario(@Valid @RequestBody Cita_Tratamiento ct) {
        try {
            if (ct.getEstado() == null || ct.getEstado().trim().isEmpty()) {
                ct.setEstado("Activo");
            }

            Cita_Tratamiento citaTratamiento = citaTratamientoService.create(ct);
            return new ResponseEntity<>(citaTratamiento, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear cita-tratamiento: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita_Tratamiento> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Cita_Tratamiento c = citaTratamientoService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cita_Tratamiento> delUsuario(@PathVariable("id") Long id) {
        try {
            citaTratamientoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita_Tratamiento> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Cita_Tratamiento ct) {
        Optional<Cita_Tratamiento> citaTratamiento = citaTratamientoService.read(id);
        if (citaTratamiento.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(citaTratamientoService.update(ct), HttpStatus.OK);

        }
    }
}
