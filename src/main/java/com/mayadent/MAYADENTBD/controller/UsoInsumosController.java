package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Tratamiento;
import com.mayadent.MAYADENTBD.entity.UsoInsumos;
import com.mayadent.MAYADENTBD.service.TratamientoService;
import com.mayadent.MAYADENTBD.service.UsoInsumosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usoInsumos")
@CrossOrigin(origins = "http://localhost:4200")

public class UsoInsumosController {
    @Autowired
    private UsoInsumosService usoInsumosService;
    @GetMapping
    public ResponseEntity<List<UsoInsumos>> readAll() {
        try {
            List<UsoInsumos> usoInsumos = usoInsumosService.readAll();
            if (usoInsumos.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(usoInsumos, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<UsoInsumos> crearUsuario(@Valid @RequestBody UsoInsumos ui) {
        try {
            if (ui.getEstado() == null || ui.getEstado().trim().isEmpty()) {
                ui.setEstado("Activo");
            }

            UsoInsumos usoInsumos = usoInsumosService.create(ui);
            return new ResponseEntity<>(usoInsumos, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear uso de insumos: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsoInsumos> getUsuarioId(@PathVariable("id") Long id) {
        try {
            UsoInsumos usoInsumos = usoInsumosService.read(id).get();
            return new ResponseEntity<>(usoInsumos, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsoInsumos> delUsuario(@PathVariable("id") Long id) {
        try {
            usoInsumosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsoInsumos> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody UsoInsumos ui) {
        Optional<UsoInsumos> usoInsumos = usoInsumosService.read(id);
        if (usoInsumos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usoInsumosService.update(ui), HttpStatus.OK);

        }
    }
}
