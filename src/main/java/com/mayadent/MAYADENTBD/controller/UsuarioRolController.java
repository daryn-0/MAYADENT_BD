package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Usuario;
import com.mayadent.MAYADENTBD.entity.UsuarioRol;
import com.mayadent.MAYADENTBD.service.UsuarioRolService;
import com.mayadent.MAYADENTBD.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarioRols")
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioRolController {
    @Autowired
    private UsuarioRolService usuarioRolService;
    @GetMapping
    public ResponseEntity<List<UsuarioRol>> readAll() {
        try {
            List<UsuarioRol> usuarioRols = usuarioRolService.readAll();
            if (usuarioRols.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(usuarioRols, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioRol> crearUsuario(@Valid @RequestBody UsuarioRol ur) {
        try {
            if (ur.getEstado() == null || ur.getEstado().trim().isEmpty()) {
                ur.setEstado("Activo");
            }

            UsuarioRol usuarioRol = usuarioRolService.create(ur);
            return new ResponseEntity<>(usuarioRol, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear usuarioRol: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRol> getUsuarioId(@PathVariable("id") Long id) {
        try {
            UsuarioRol usuarioRol = usuarioRolService.read(id).get();
            return new ResponseEntity<>(usuarioRol, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioRol> delUsuario(@PathVariable("id") Long id) {
        try {
            usuarioRolService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioRol> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody UsuarioRol ur) {
        Optional<UsuarioRol> usuarioRol = usuarioRolService.read(id);
        if (usuarioRol.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usuarioRolService.update(ur), HttpStatus.OK);

        }
    }
}
