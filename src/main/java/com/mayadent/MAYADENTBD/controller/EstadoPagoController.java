package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.EstadoCita;
import com.mayadent.MAYADENTBD.entity.EstadoPago;
import com.mayadent.MAYADENTBD.service.EstadoCitaService;
import com.mayadent.MAYADENTBD.service.EstadoPagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadoPagos")
@CrossOrigin(origins = "http://localhost:4200")

public class EstadoPagoController {
    @Autowired
    private EstadoPagoService estadoPagoService;
    @GetMapping
    public ResponseEntity<List<EstadoPago>> readAll() {
        try {
            List<EstadoPago> estadoPagos = estadoPagoService.readAll();
            if (estadoPagos.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(estadoPagos, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<EstadoPago> crearUsuario(@Valid @RequestBody EstadoPago ep) {
        try {
            if (ep.getEstado() == null || ep.getEstado().trim().isEmpty()) {
                ep.setEstado("Activo");
            }

            EstadoPago estadoPago = estadoPagoService.create(ep);
            return new ResponseEntity<>(estadoPago, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear estado de pago: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPago> getUsuarioId(@PathVariable("id") Long id) {
        try {
            EstadoPago estadoPago = estadoPagoService.read(id).get();
            return new ResponseEntity<>(estadoPago, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstadoPago> delUsuario(@PathVariable("id") Long id) {
        try {
            estadoPagoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoPago> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody EstadoPago ep) {
        Optional<EstadoPago> estadoPago = estadoPagoService.read(id);
        if (estadoPago.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(estadoPagoService.update(ep), HttpStatus.OK);

        }
    }
}
