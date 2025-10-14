package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.EstadoPago;
import com.mayadent.MAYADENTBD.entity.Factura;
import com.mayadent.MAYADENTBD.service.EstadoPagoService;
import com.mayadent.MAYADENTBD.service.FacturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;
    @GetMapping
    public ResponseEntity<List<Factura>> readAll() {
        try {
            List<Factura> facturas = facturaService.readAll();
            if (facturas.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(facturas, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Factura> crearUsuario(@Valid @RequestBody Factura f) {
        try {
            Factura factura = facturaService.create(f);
            return new ResponseEntity<>(factura, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Factura factura = facturaService.read(id).get();
            return new ResponseEntity<>(factura, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Factura> delUsuario(@PathVariable("id") Long id) {
        try {
            facturaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Factura f) {
        Optional<Factura> factura = facturaService.read(id);
        if (factura.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(facturaService.update(f), HttpStatus.OK);

        }
    }
}
