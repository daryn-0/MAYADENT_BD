package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.dto.NotificacionDto;
import org.springframework.stereotype.Service;

@Service
public interface NotificacionService {
    void sendNotificacion(NotificacionDto notificacion);
}
