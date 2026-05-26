package com.mayadent.MAYADENTBD.service;

import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.entity.Cita_Tratamiento;
import com.mayadent.MAYADENTBD.entity.Doctor;
import com.mayadent.MAYADENTBD.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecordatorioService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CitaTratamientoService citaTratamientoService;

    @Scheduled(cron = "0 * * * * *")
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
                // Solo enviar recordatorios de citas confirmadas (estadoCita.id == 2)
                if (cita.getEstadoCita() == null || cita.getEstadoCita().getId() == null || cita.getEstadoCita().getId() != 2) {
                    System.out.println("Cita ID " + cita.getId() + " no está confirmada (estado: " + 
                        (cita.getEstadoCita() != null ? cita.getEstadoCita().getId() : "null") + "). Omitiendo recordatorio.");
                    continue;
                }

                String correoPaciente = cita.getPaciente().getCorreo();
                String correoUsuario = cita.getUsuario() != null ? cita.getUsuario().getCorreo() : null;

                // Obtener doctores de los tratamientos asignados
                Set<Long> idsDoctoresAsignados = new HashSet<>();
                List<Doctor> doctoresAsignados = citaTratamientoService.findByCitaId(cita.getId()).stream()
                        .map(Cita_Tratamiento::getTratamiento)
                        .filter(tratamiento -> tratamiento != null && tratamiento.getDoctor() != null)
                        .map(tratamiento -> tratamiento.getDoctor())
                        .filter(doctor -> doctor.getId() != null)
                        .filter(doctor -> idsDoctoresAsignados.add(doctor.getId()))
                        .toList();

                String nombresDoctoresAsignados = doctoresAsignados.isEmpty()
                        ? (cita.getUsuario() != null ? cita.getUsuario().getNombre() + " " + cita.getUsuario().getApellido() : "No asignado")
                        : doctoresAsignados.stream()
                        .map(doctor -> doctor.getNombre() + " " + doctor.getApellido())
                        .reduce((doctor1, doctor2) -> doctor1 + ", " + doctor2)
                        .orElse("");

                if (correoPaciente != null && !correoPaciente.isBlank()) {
                    String mensajePaciente = String.format(
                            "Estimado/a %s %s,\n\n" +
                                    "Le recordamos su cita odontológica programada para mañana (%s) a las %s.\n" +
                                    "Doctores asignados: %s\n\n" +
                                    "Por favor, llegue 10 minutos antes.\n\n" +
                                    "Clínica Odontológica MAYADENT",
                            cita.getPaciente().getNombre(),
                            cita.getPaciente().getApellido(),
                            cita.getFecha_cita(),
                            cita.getHora_cita(),
                            nombresDoctoresAsignados
                    );
                    emailService.enviarCorreo(correoPaciente, "Recordatorio de Cita Odontológica", mensajePaciente);
                }

                // Enviar recordatorio a los doctores asignados
                if (!doctoresAsignados.isEmpty()) {
                    for (Doctor doctor : doctoresAsignados) {
                        String correoDoctor = doctor.getCorreo();
                        if (correoDoctor != null && !correoDoctor.isBlank()) {
                            String mensajeDoctor = String.format(
                                    "Estimado/a Dr(a). %s %s,\n\n" +
                                            "Le recordamos que tiene una cita programada para mañana (%s) a las %s.\n" +
                                            "Paciente: %s %s\n" +
                                            "Doctores asignados: %s\n\n" +
                                            "Clínica Odontológica MAYADENT",
                                    doctor.getNombre(),
                                    doctor.getApellido(),
                                    cita.getFecha_cita(),
                                    cita.getHora_cita(),
                                    cita.getPaciente().getNombre(),
                                    cita.getPaciente().getApellido(),
                                    nombresDoctoresAsignados
                            );
                            emailService.enviarCorreo(correoDoctor, "Recordatorio de Cita Asignada", mensajeDoctor);
                        }
                    }
                } else if (correoUsuario != null && !correoUsuario.isBlank()) {
                    String mensajeUsuario = String.format(
                            "Estimado/a Dr(a). %s %s,\n\n" +
                                    "Le recordamos que tiene una cita programada para mañana (%s) a las %s.\n" +
                                    "Paciente: %s %s\n" +
                                    "Doctores asignados: %s\n\n" +
                                    "Clínica Odontológica MAYADENT",
                            cita.getUsuario().getNombre(),
                            cita.getUsuario().getApellido(),
                            cita.getFecha_cita(),
                            cita.getHora_cita(),
                            cita.getPaciente().getNombre(),
                            cita.getPaciente().getApellido(),
                            nombresDoctoresAsignados
                    );
                    emailService.enviarCorreo(correoUsuario, "Recordatorio de Cita Asignada", mensajeUsuario);
                }

                System.out.println("Recordatorio enviado para cita ID: " + cita.getId());

            } catch (Exception e) {
                System.err.println("Error al enviar recordatorio para cita ID: " + cita.getId());
                e.printStackTrace();
            }
        }
    }
}
