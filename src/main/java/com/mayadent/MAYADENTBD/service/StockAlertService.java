package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Inventario;
import com.mayadent.MAYADENTBD.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockAlertService {
    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 8 * * *")
    public void verificarStockBajo() {
        int limiteCritico = 2;

        System.out.println("Verificando niveles de stock...");

        List<Inventario> inventarios = inventarioRepository.findAll();

        for (Inventario inv : inventarios) {
            try {
                if (inv.getCantidad() <= limiteCritico) {

                    String correoDestino = null;

                    if (inv.getUsuario() != null && inv.getUsuario().getCorreo() != null) {
                        correoDestino = inv.getUsuario().getCorreo();
                    }

                    if (correoDestino == null || correoDestino.isBlank()) {
                        correoDestino = "compras@mayadent.com";
                    }

                    String asunto = "Alerta de Stock Bajo: " + inv.getNombre();
                    String mensaje = String.format(
                            "Estimado/a %s %s,\n\n" +
                                    "El producto **%s** tiene un stock bajo (%d unidades).\n" +
                                    "Por favor, considere realizar un nuevo pedido o reposición.\n\n" +
                                    "Código: %s\n" +
                                    "Fecha: %s\n\n" +
                                    "Atentamente,\nSistema de Inventario - Clínica Odontológica MAYADENT",
                            inv.getUsuario() != null ? inv.getUsuario().getNombre() : "Usuario",
                            inv.getUsuario() != null ? inv.getUsuario().getApellido() : "",
                            inv.getNombre(),
                            inv.getCantidad(),
                            inv.getId(),
                            java.time.LocalDate.now()
                    );

                    emailService.enviarCorreo(correoDestino, asunto, mensaje);

                    System.out.println("Alerta enviada a: " + correoDestino + " por producto: " + inv.getNombre());
                }
            } catch (Exception e) {
                System.err.println("Error al enviar alerta para producto: " + inv.getNombre());
                e.printStackTrace();
            }
        }

        System.out.println("Verificación de stock completada.");
    }
}
