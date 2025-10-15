package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dto.NotificacionDto;
import com.mayadent.MAYADENTBD.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificacionServiceImpl implements NotificacionService {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public void sendNotificacion(NotificacionDto notificacion) {
        String destination = "/topic/notifications";

        if (notificacion.getRecipientRole() != null && notificacion.getRecipientId() != null) {
            destination = "/topic/notifications/" + notificacion.getRecipientRole().toLowerCase() + "/" + notificacion.getRecipientId();
        }

        messagingTemplate.convertAndSend(destination, notificacion);
    }
}
