package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.DetalleFactura;
import com.mayadent.MAYADENTBD.entity.EstadoCita;
import com.mayadent.MAYADENTBD.service.DetalleFacturaService;
import com.mayadent.MAYADENTBD.service.EstadoCitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadoCitas")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoCitaController {
    @Autowired
    private EstadoCitaService estadoCitaService;
    @GetMapping
    public ResponseEntity<List<EstadoCita>> readAll() {
        try {
            List<EstadoCita> estadoCitas = estadoCitaService.readAll();
            if (estadoCitas.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(estadoCitas, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<EstadoCita> crearUsuario(@Valid @RequestBody EstadoCita ec) {
        try {
            // ⚙️ Si el campo estado no viene o está vacío → se asigna "Activo" por defecto
            if (ec.getEstado() == null || ec.getEstado().trim().isEmpty()) {
                ec.setEstado("Activo");
            }

            EstadoCita estadoCita = estadoCitaService.create(ec);
            return new ResponseEntity<>(estadoCita, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear estado de cita: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoCita> getUsuarioId(@PathVariable("id") Long id) {
        try {
            EstadoCita estadoCita = estadoCitaService.read(id).get();
            return new ResponseEntity<>(estadoCita, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstadoCita> delUsuario(@PathVariable("id") Long id) {
        try {
            estadoCitaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoCita> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody EstadoCita ec) {
        Optional<EstadoCita> estadoCita = estadoCitaService.read(id);
        if (estadoCita.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(estadoCitaService.update(ec), HttpStatus.OK);

        }
    }
}
