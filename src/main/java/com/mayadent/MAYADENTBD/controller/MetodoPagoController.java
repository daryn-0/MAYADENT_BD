package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Inventario;
import com.mayadent.MAYADENTBD.entity.MetodoPago;
import com.mayadent.MAYADENTBD.service.InventarioService;
import com.mayadent.MAYADENTBD.service.MetodoPagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metodoPagos")
@CrossOrigin(origins = "http://localhost:4200")

public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;
    @GetMapping
    public ResponseEntity<List<MetodoPago>> readAll() {
        try {
            List<MetodoPago> metodoPagos = metodoPagoService.readAll();
            if (metodoPagos.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(metodoPagos, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<MetodoPago> crearUsuario(@Valid @RequestBody MetodoPago mp) {
        try {
            MetodoPago metodoPago = metodoPagoService.create(mp);
            return new ResponseEntity<>(metodoPago, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> getUsuarioId(@PathVariable("id") Long id) {
        try {
            MetodoPago metodoPago = metodoPagoService.read(id).get();
            return new ResponseEntity<>(metodoPago, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MetodoPago> delUsuario(@PathVariable("id") Long id) {
        try {
            metodoPagoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody MetodoPago mp) {
        Optional<MetodoPago> metodoPago = metodoPagoService.read(id);
        if (metodoPago.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(metodoPagoService.update(mp), HttpStatus.OK);

        }
    }
}
