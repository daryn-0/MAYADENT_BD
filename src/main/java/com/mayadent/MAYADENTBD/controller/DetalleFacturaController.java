package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Cita_Tratamiento;
import com.mayadent.MAYADENTBD.entity.DetalleFactura;
import com.mayadent.MAYADENTBD.service.CitaTratamientoService;
import com.mayadent.MAYADENTBD.service.DetalleFacturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalleFacturas")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleFacturaController {
    @Autowired
    private DetalleFacturaService detalleFacturaService;
    @GetMapping
    public ResponseEntity<List<DetalleFactura>> readAll() {
        try {
            List<DetalleFactura> detalleFacturas = detalleFacturaService.readAll();
            if (detalleFacturas.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(detalleFacturas, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<DetalleFactura> crearUsuario(@Valid @RequestBody DetalleFactura df) {
        try {
            if (df.getEstado() == null || df.getEstado().trim().isEmpty()) {
                df.setEstado("Activo");
            }

            DetalleFactura detalleFactura = detalleFacturaService.create(df);
            return new ResponseEntity<>(detalleFactura, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error al crear detalle de factura: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFactura> getUsuarioId(@PathVariable("id") Long id) {
        try {
            DetalleFactura detalleFactura = detalleFacturaService.read(id).get();
            return new ResponseEntity<>(detalleFactura, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetalleFactura> delUsuario(@PathVariable("id") Long id) {
        try {
            detalleFacturaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleFactura> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody DetalleFactura df) {
        Optional<DetalleFactura> detalleFactura = detalleFacturaService.read(id);
        if (detalleFactura.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(detalleFacturaService.update(df), HttpStatus.OK);

        }
    }
}
