package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Paciente;
import com.mayadent.MAYADENTBD.entity.Rol;
import com.mayadent.MAYADENTBD.service.PacienteService;
import com.mayadent.MAYADENTBD.service.RolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "http://localhost:4200")

public class RolController {
    @Autowired
    private RolService rolService;
    @GetMapping
    public ResponseEntity<List<Rol>> readAll() {
        try {
            List<Rol> rols = rolService.readAll();
            if (rols.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(rols, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Rol> crearUsuario(@Valid @RequestBody Rol r) {
        try {
            if (r.getEstado() == null || r.getEstado().trim().isEmpty()) {
                r.setEstado("Activo");
            }

            Rol rol = rolService.create(r);
            return new ResponseEntity<>(rol, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear rol: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Rol rol = rolService.read(id).get();
            return new ResponseEntity<>(rol, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rol> delUsuario(@PathVariable("id") Long id) {
        try {
            rolService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Rol r) {
        Optional<Rol> rol= rolService.read(id);
        if (rol.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(rolService.update(r), HttpStatus.OK);

        }
    }
}
