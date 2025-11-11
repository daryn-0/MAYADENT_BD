package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Usuario;
import com.mayadent.MAYADENTBD.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public ResponseEntity<List<Usuario>> readAll() {
        try {
            List<Usuario> usuarios = usuarioService.readAll();
            if (usuarios.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(usuarios, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody Usuario us) {
        try {
            if (us.getEstado() == null || us.getEstado().trim().isEmpty()) {
                us.setEstado("Activo");
            }

            Usuario u = usuarioService.create(us);
            return new ResponseEntity<>(u, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Usuario u = usuarioService.read(id).get();
            return new ResponseEntity<>(u, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delUsuario(@PathVariable("id") Long id) {
        try {
            usuarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario us) {
        Optional<Usuario> u = usuarioService.read(id);
        if (u.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usuarioService.update(us), HttpStatus.OK);

        }
    }
}
