package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecordatorioService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 8 * * *")
    public void enviarRecordatorios() {
        LocalDate manana = LocalDate.now().plusDays(1);
        System.out.println("Buscando citas para el día: " + manana);

        List<Cita> citas = citaRepository.findByFecha_Cita(manana);
        if (citas.isEmpty()) {
            System.out.println("No hay citas para mañana.");
            return;
        }

        for (Cita cita : citas) {
            try {
                String correoPaciente = cita.getPaciente().getCorreo();
                String correoDoctor = cita.getUsuario().getCorreo();

                if (correoPaciente != null && !correoPaciente.isBlank()) {
                    String mensajePaciente = String.format(
                            "Estimado/a %s %s,\n\nLe recordamos su cita odontológica programada para mañana (%s) a las %s con el Dr(a). %s %s.\n\nPor favor, llegue 10 minutos antes.\n\nClínica Odontológica MAYADENT",
                            cita.getPaciente().getNombre(),
                            cita.getPaciente().getApellido(),
                            cita.getFecha_cita(),
                            cita.getHora_cita(),
                            cita.getUsuario().getNombre(),
                            cita.getUsuario().getApellido()
                    );
                    emailService.enviarCorreo(correoPaciente, "Recordatorio de Cita Odontológica", mensajePaciente);
                }

                if (correoDoctor != null && !correoDoctor.isBlank()) {
                    String mensajeDoctor = String.format(
                            "Estimado/a Dr(a). %s %s,\n\nLe recordamos que tiene una cita programada para mañana (%s) a las %s con el/la paciente %s %s.\n\nClínica Odontológica MAYADENT",
                            cita.getUsuario().getNombre(),
                            cita.getUsuario().getApellido(),
                            cita.getFecha_cita(),
                            cita.getHora_cita(),
                            cita.getPaciente().getNombre(),
                            cita.getPaciente().getApellido()
                    );
                    emailService.enviarCorreo(correoDoctor, "Recordatorio de Cita Asignada", mensajeDoctor);
                }

                System.out.println("Recordatorio enviado para cita ID: " + cita.getId());

            } catch (Exception e) {
                System.err.println("Error al enviar recordatorio para cita ID: " + cita.getId());
                e.printStackTrace();
            }
        }
    }
}
