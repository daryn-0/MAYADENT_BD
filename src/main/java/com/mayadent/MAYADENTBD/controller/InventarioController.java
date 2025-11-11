package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.HistoriaClinica;
import com.mayadent.MAYADENTBD.entity.Inventario;
import com.mayadent.MAYADENTBD.service.HistoriaClinicaService;
import com.mayadent.MAYADENTBD.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventarios")
@CrossOrigin(origins = "http://localhost:4200")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;
    @GetMapping
    public ResponseEntity<List<Inventario>> readAll() {
        try {
            List<Inventario> inventarios = inventarioService.readAll();
            if (inventarios.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(inventarios, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Inventario> crearUsuario(@Valid @RequestBody Inventario in) {
        try {
            if (in.getEstado() == null || in.getEstado().trim().isEmpty()) {
                in.setEstado("Activo");
            }

            Inventario inventario = inventarioService.create(in);
            return new ResponseEntity<>(inventario, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear inventario: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Inventario inventario = inventarioService.read(id).get();
            return new ResponseEntity<>(inventario, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Inventario> delUsuario(@PathVariable("id") Long id) {
        try {
            inventarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Inventario in) {
        Optional<Inventario> inventario = inventarioService.read(id);
        if (inventario.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(inventarioService.update(in), HttpStatus.OK);

        }
    }
}
