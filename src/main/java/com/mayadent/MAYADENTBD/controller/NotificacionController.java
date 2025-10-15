package com.mayadent.MAYADENTBD.controller;

import com.mayadent.MAYADENTBD.dto.NotificacionDto;
import com.mayadent.MAYADENTBD.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificaciones")
@CrossOrigin(origins = "http://localhost:4200")

public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @PostMapping("/send")
    public String sendNotificacion(@RequestBody NotificacionDto notificacion) {
        notificacionService.sendNotificacion(notificacion);
        return "Notificación enviada correctamente a " + (notificacion.getRecipientRole() != null ? notificacion.getRecipientRole() : "todos");
    }
}
