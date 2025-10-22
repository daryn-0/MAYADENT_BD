package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.service.CitaService;
import com.mayadent.MAYADENTBD.serviceImpl.EmailNotificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaController {
    @Autowired
    private CitaService citaService;
    @Autowired
    private EmailNotificacionService emailNotificacionService;

    @GetMapping
    public ResponseEntity<List<Cita>> readAll() {
        try {
            List<Cita> citas = citaService.readAll();
            if (citas.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(citas, HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Cita> crearUsuario(@Valid @RequestBody Cita ci) {
        try {
            Cita c = citaService.create(ci);
            String emailPaciente = c.getPaciente().getCorreo();
            String emailDoctor = c.getUsuario().getCorreo();
            String subjectPaciente = "Confirmación de Cita Médica";
            String textPaciente = "Hola " + c.getPaciente().getNombre() + ",\n\n" +
                    "Tu cita ha sido programada con el Dr. " + c.getUsuario().getNombre() + ".\n" +
                    "Detalles de la cita:\n" +
                    "Fecha: " + c.getFecha_cita() + "\n" +
                    "Hora: " + c.getHora_cita() + "\n\n" +
                    "¡Nos vemos pronto!";
            emailNotificacionService.sendMail(emailPaciente, subjectPaciente, textPaciente);

            String subjectDoctor = "Nueva Cita Asignada";
            String textDoctor = "Hola " + c.getUsuario().getNombre() + ",\n\n" +
                    "Tienes una nueva cita programada con el paciente " + c.getPaciente().getNombre() + ".\n" +
                    "Detalles de la cita:\n" +
                    "Fecha: " + c.getFecha_cita() + "\n" +
                    "Hora: " + c.getHora_cita() + "\n\n" +
                    "¡No olvides estar preparado para la consulta!";
            emailNotificacionService.sendMail(emailDoctor, subjectDoctor, textDoctor);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Cita c = citaService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<List<Cita>> getCitasByDni(@PathVariable("dni") String dni) {
        List<Cita> citas = citaService.findByDniPaciente(dni);
        if (citas.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(citas);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cita> delUsuario(@PathVariable("id") Long id) {
        try {
            citaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Cita ci) {
        Optional<Cita> c = citaService.read(id);
        if (c.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(citaService.update(ci), HttpStatus.OK);

        }
    }
}
