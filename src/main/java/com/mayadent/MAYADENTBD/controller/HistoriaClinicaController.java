package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.HistoriaClinica;
import com.mayadent.MAYADENTBD.service.HistoriaClinicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historiaClinicas")
@CrossOrigin(origins = "http://localhost:4200")

public class HistoriaClinicaController {
    @Autowired
    private HistoriaClinicaService historiaClinicaService;
    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> readAll() {
        try {
            List<HistoriaClinica> historiaClinicas = historiaClinicaService.readAll();
            if (historiaClinicas.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(historiaClinicas, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<HistoriaClinica> crearUsuario(@Valid @RequestBody HistoriaClinica hc) {
        try {
            if (hc.getEstado() == null || hc.getEstado().trim().isEmpty()) {
                hc.setEstado("Activo");
            }

            HistoriaClinica historiaClinica = historiaClinicaService.create(hc);
            return new ResponseEntity<>(historiaClinica, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear historia clínica: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> getUsuarioId(@PathVariable("id") Long id) {
        try {
            HistoriaClinica historiaClinica = historiaClinicaService.read(id).get();
            return new ResponseEntity<>(historiaClinica, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HistoriaClinica> delUsuario(@PathVariable("id") Long id) {
        try {
            historiaClinicaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody HistoriaClinica hc) {
        Optional<HistoriaClinica> historiaClinica = historiaClinicaService.read(id);
        if (historiaClinica.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(historiaClinicaService.update(hc), HttpStatus.OK);

        }
    }
}
