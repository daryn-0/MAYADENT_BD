package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.CitaDao;
import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.entity.Cita_Tratamiento;
import com.mayadent.MAYADENTBD.entity.Doctor;
import com.mayadent.MAYADENTBD.entity.HistoriaClinica;
import com.mayadent.MAYADENTBD.entity.Paciente;
import com.mayadent.MAYADENTBD.entity.Usuario;
import com.mayadent.MAYADENTBD.service.CitaTratamientoService;
import com.mayadent.MAYADENTBD.service.CitaService;
import com.mayadent.MAYADENTBD.service.EmailService;
import com.mayadent.MAYADENTBD.service.HistoriaClinicaService;
import com.mayadent.MAYADENTBD.service.PacienteService;
import com.mayadent.MAYADENTBD.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaDao citaDao;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CitaTratamientoService citaTratamientoService;

    @Autowired
    private HistoriaClinicaService historiaClinicaService;


    @Transactional
    @Override
    public Cita create(Cita c) {
        Cita nuevaCita = citaDao.create(c);

        try {
            if (nuevaCita.getPaciente() != null && nuevaCita.getUsuario() != null) {

                Paciente paciente = pacienteService.read(nuevaCita.getPaciente().getId()).orElse(null);
                Usuario usuario = usuarioService.read(nuevaCita.getUsuario().getId()).orElse(null);

                if (paciente == null || usuario == null) {
                    System.err.println("No se encontraron datos válidos de paciente o usuario.");
                    return nuevaCita;
                }

                String correoPaciente = paciente.getCorreo();
                String correoUsuario = usuario.getCorreo();
                Set<Long> idsDoctoresAsignados = new HashSet<>();
                List<Doctor> doctoresAsignados = citaTratamientoService.findByCitaId(nuevaCita.getId()).stream()
                        .map(Cita_Tratamiento::getTratamiento)
                        .filter(tratamiento -> tratamiento != null && tratamiento.getDoctor() != null)
                        .map(tratamiento -> tratamiento.getDoctor())
                        .filter(doctor -> doctor.getId() != null)
                        .filter(doctor -> idsDoctoresAsignados.add(doctor.getId()))
                        .toList();
                String nombresDoctoresAsignados = doctoresAsignados.isEmpty()
                        ? usuario.getNombre() + " " + usuario.getApellido()
                        : doctoresAsignados.stream()
                        .map(doctor -> doctor.getNombre() + " " + doctor.getApellido())
                        .reduce((doctor1, doctor2) -> doctor1 + ", " + doctor2)
                        .orElse("");

                System.out.println("Correo Paciente: " + correoPaciente);
                System.out.println("Correo Usuario: " + correoUsuario);

                String asunto = "Confirmación de Cita Odontológica";

                String mensajePaciente = String.format(
                        "Estimado/a %s %s,\n\n" +
                                "Su cita ha sido registrada exitosamente en el sistema.\n" +
                                "Fecha: %s\n" +
                                "Hora: %s\n\n" +
                                "Su cita se encuentra pendiente de confirmación por parte del doctor.\n" +
                                "Recibirá un correo de confirmación una vez que el doctor la apruebe.\n\n" +
                                "Gracias por confiar en nosotros.\n" +
                                "Clínica Odontológica MAYADENT.",
                        paciente.getNombre(),
                        paciente.getApellido(),
                        nuevaCita.getFecha_cita(),
                        nuevaCita.getHora_cita()
                );

                if (correoPaciente != null && !correoPaciente.isBlank()) {
                    emailService.enviarCorreo(correoPaciente, asunto, mensajePaciente);
                } else {
                    System.err.println("Paciente sin correo registrado, no se envió notificación.");
                }

                if (!doctoresAsignados.isEmpty()) {
                    for (Doctor doctor : doctoresAsignados) {
                        String correoDoctor = doctor.getCorreo();
                        String mensajeDoctor = String.format(
                                "Estimado/a Dr(a). %s %s,\n\n" +
                                        "Se le ha asignado una nueva cita.\n" +
                                        "Paciente: %s %s\n" +
                                        "Fecha: %s\n" +
                                        "Hora: %s\n" +
                                        "Doctores asignados: %s\n\n" +
                                        "Clínica Odontológica MAYADENT",
                                doctor.getNombre(),
                                doctor.getApellido(),
                                paciente.getNombre(),
                                paciente.getApellido(),
                                nuevaCita.getFecha_cita(),
                                nuevaCita.getHora_cita(),
                                nombresDoctoresAsignados
                        );

                        if (correoDoctor != null && !correoDoctor.isBlank()) {
                            emailService.enviarCorreo(correoDoctor, asunto, mensajeDoctor);
                        } else {
                            System.err.println("Doctor sin correo registrado, no se envió notificación.");
                        }
                    }
                } else if (correoUsuario != null && !correoUsuario.isBlank()) {
                    String mensajeUsuario = String.format(
                            "Estimado/a Dr(a). %s %s,\n\n" +
                                    "Se le ha asignado una nueva cita.\n" +
                                    "Paciente: %s %s\n" +
                                    "Fecha: %s\n" +
                                    "Hora: %s\n" +
                                    "Doctores asignados: %s\n\n" +
                                    "Clínica Odontológica MAYADENT",
                            usuario.getNombre(),
                            usuario.getApellido(),
                            paciente.getNombre(),
                            paciente.getApellido(),
                            nuevaCita.getFecha_cita(),
                            nuevaCita.getHora_cita(),
                            nombresDoctoresAsignados
                    );
                    emailService.enviarCorreo(correoUsuario, asunto, mensajeUsuario);
                } else {
                    System.err.println("Usuario sin correo registrado, no se envió notificación.");
                }
            } else {
                System.err.println("Paciente o usuario nulos al registrar la cita.");
            }

        } catch (Exception e) {
            System.err.println("Error al enviar correo: " + e.getMessage());
            e.printStackTrace();
        }

        return nuevaCita;
    }

    @Override
    public Cita update(Cita c) {
        Cita citaAnterior = c.getId() != null ? citaDao.read(c.getId()).orElse(null) : null;
        Long estadoAnteriorId = citaAnterior != null && citaAnterior.getEstadoCita() != null ? citaAnterior.getEstadoCita().getId() : null;
        Long estadoNuevoId = c.getEstadoCita() != null ? c.getEstadoCita().getId() : null;
        Cita citaActualizada = citaDao.update(c);

        if (Long.valueOf(2).equals(estadoAnteriorId) && Long.valueOf(3).equals(estadoNuevoId) && !historiaClinicaService.existsByCitaId(citaActualizada.getId())) {
            HistoriaClinica historiaClinica = HistoriaClinica.builder()
                    .fecha_emision(new Date())
                    .monto_total(0)
                    .estado("Activo")
                    .paciente(citaActualizada.getPaciente())
                    .cita(citaActualizada)
                    .build();
            historiaClinicaService.create(historiaClinica);
        }

        try {
            if (citaActualizada.getPaciente() != null && citaActualizada.getUsuario() != null && citaActualizada.getEstadoCita() != null) {

                Paciente paciente = pacienteService.read(citaActualizada.getPaciente().getId()).orElse(null);
                Usuario usuario = usuarioService.read(citaActualizada.getUsuario().getId()).orElse(null);

                if (paciente == null || usuario == null) {
                    System.err.println("No se encontraron datos válidos de paciente o usuario para enviar notificación.");
                    return citaActualizada;
                }

                String correoPaciente = paciente.getCorreo();
                if (correoPaciente == null || correoPaciente.isBlank()) {
                    System.err.println("Paciente sin correo registrado. No se enviará correo.");
                    return citaActualizada;
                }

                Set<Long> idsDoctoresAsignados = new HashSet<>();
                List<Doctor> doctoresAsignados = citaTratamientoService.findByCitaId(citaActualizada.getId()).stream()
                        .map(Cita_Tratamiento::getTratamiento)
                        .filter(tratamiento -> tratamiento != null && tratamiento.getDoctor() != null)
                        .map(tratamiento -> tratamiento.getDoctor())
                        .filter(doctor -> doctor.getId() != null)
                        .filter(doctor -> idsDoctoresAsignados.add(doctor.getId()))
                        .toList();
                String nombresDoctoresAsignados = doctoresAsignados.isEmpty()
                        ? usuario.getNombre() + " " + usuario.getApellido()
                        : doctoresAsignados.stream()
                        .map(doctor -> doctor.getNombre() + " " + doctor.getApellido())
                        .reduce((doctor1, doctor2) -> doctor1 + ", " + doctor2)
                        .orElse("");

                Long estadoId = citaActualizada.getEstadoCita().getId();
                String asunto = "";
                String mensaje = "";

                switch (estadoId.intValue()) {
                    case 2 -> {
                        asunto = "Confirmación de su Cita Odontológica - Clínica MAYADENT";
                        mensaje = String.format(
                                "Estimado/a %s %s,\n\nSu cita odontológica ha sido *confirmada* por el doctor.\n" +
                                        "Fecha: %s\nHora: %s\nDoctor: %s\n\n" +
                                        "Por favor, llegue 10 minutos antes de la hora programada.\n\n" +
                                        "Clínica Odontológica MAYADENT.",
                                paciente.getNombre(),
                                paciente.getApellido(),
                                citaActualizada.getFecha_cita(),
                                citaActualizada.getHora_cita(),
                                nombresDoctoresAsignados
                        );
                    }
                    case 4 -> {
                        asunto = "Cancelación de su Cita Odontológica - Clínica MAYADENT";
                        mensaje = String.format(
                                "Estimado/a %s %s,\n\nLamentamos informarle que su cita programada para:\n" +
                                        "Fecha: %s\nHora: %s\nDoctor: %s\n\n" +
                                        "ha sido *cancelada*. Puede comunicarse con nosotros para reprogramarla.\n\n" +
                                        "Clínica Odontológica MAYADENT.",
                                paciente.getNombre(),
                                paciente.getApellido(),
                                citaActualizada.getFecha_cita(),
                                citaActualizada.getHora_cita(),
                                nombresDoctoresAsignados
                        );
                    }
                    default -> System.out.println("Estado de cita no requiere notificación. ID: " + estadoId);
                }

                if (!mensaje.isEmpty()) {
                    emailService.enviarCorreo(correoPaciente, asunto, mensaje);
                    System.out.println("Correo enviado al paciente: " + correoPaciente + " (Estado ID: " + estadoId + ")");
                }

            } else {
                System.err.println("Cita sin datos completos (paciente, usuario o estadoCita nulos).");
            }

        } catch (Exception e) {
            System.err.println("Error al enviar correo de actualización de cita: " + e.getMessage());
            e.printStackTrace();
        }

        return citaActualizada;
    }

    @Override
    public Optional<Cita>read(Long id) {
        return citaDao.read(id);
    }

    @Override
    public void delete(Long id) {
        citaDao.delete(id);
    }

    @Override
    public List<Cita> readAll() {
        return citaDao.readAll();
    }

    @Override
    public List<Cita> findByDniPaciente(String dni) {
        return citaDao.findByDniPaciente(dni);
    }

    @Override
    public void enviarCorreoConfirmacion(Long citaId) {
        try {
            Optional<Cita> citaOpt = citaDao.read(citaId);
            if (citaOpt.isEmpty()) {
                System.err.println("Cita no encontrada para enviar correo: " + citaId);
                return;
            }

            Cita cita = citaOpt.get();
            if (cita.getPaciente() == null || cita.getUsuario() == null) {
                System.err.println("Cita sin paciente o usuario asignado");
                return;
            }

            Paciente paciente = pacienteService.read(cita.getPaciente().getId()).orElse(null);
            Usuario usuario = usuarioService.read(cita.getUsuario().getId()).orElse(null);

            if (paciente == null || usuario == null) {
                System.err.println("No se encontraron datos de paciente o usuario");
                return;
            }

            String correoPaciente = paciente.getCorreo();
            String correoUsuario = usuario.getCorreo();

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
                    ? usuario.getNombre() + " " + usuario.getApellido()
                    : doctoresAsignados.stream()
                    .map(doctor -> doctor.getNombre() + " " + doctor.getApellido())
                    .reduce((doctor1, doctor2) -> doctor1 + ", " + doctor2)
                    .orElse("");

            String asunto = "Confirmación de Cita Odontológica";

            String mensajePaciente = String.format(
                    "Estimado/a %s %s,\n\n" +
                            "Su cita ha sido registrada exitosamente en el sistema.\n" +
                            "Fecha: %s\n" +
                            "Hora: %s\n\n" +
                            "Su cita se encuentra pendiente de confirmación por parte del doctor.\n" +
                            "Recibirá un correo de confirmación una vez que el doctor la apruebe.\n\n" +
                            "Gracias por confiar en nosotros.\n" +
                            "Clínica Odontológica MAYADENT.",
                    paciente.getNombre(),
                    paciente.getApellido(),
                    cita.getFecha_cita(),
                    cita.getHora_cita()
            );

            // Enviar correo al paciente
            if (correoPaciente != null && !correoPaciente.isBlank()) {
                emailService.enviarCorreo(correoPaciente, asunto, mensajePaciente);
                System.out.println("Correo de confirmación enviado al paciente: " + correoPaciente);
            } else {
                System.err.println("Paciente sin correo registrado");
            }

            // Enviar correo a los doctores asignados
            if (!doctoresAsignados.isEmpty()) {
                for (Doctor doctor : doctoresAsignados) {
                    String correoDoctor = doctor.getCorreo();
                    String mensajeDoctor = String.format(
                            "Estimado/a Dr(a). %s %s,\n\nSe le ha asignado una nueva cita.\n" +
                                    "Paciente: %s %s\n" +
                                    "Fecha: %s\n" +
                                    "Hora: %s\n" +
                                    "Doctores asignados: %s\n\n" +
                                    "Clínica Odontológica MAYADENT",
                            doctor.getNombre(),
                            doctor.getApellido(),
                            paciente.getNombre(),
                            paciente.getApellido(),
                            cita.getFecha_cita(),
                            cita.getHora_cita(),
                            nombresDoctoresAsignados
                    );

                    if (correoDoctor != null && !correoDoctor.isBlank()) {
                        emailService.enviarCorreo(correoDoctor, asunto, mensajeDoctor);
                        System.out.println("Correo enviado al doctor: " + correoDoctor);
                    } else {
                        System.err.println("Doctor sin correo registrado: " + doctor.getNombre());
                    }
                }
            } else if (correoUsuario != null && !correoUsuario.isBlank()) {
                String mensajeUsuario = String.format(
                        "Estimado/a Dr(a). %s %s,\n\nSe le ha asignado una nueva cita.\n" +
                                "Paciente: %s %s\n" +
                                "Fecha: %s\n" +
                                "Hora: %s\n" +
                                "Doctores asignados: %s\n\n" +
                                "Clínica Odontológica MAYADENT",
                        usuario.getNombre(),
                        usuario.getApellido(),
                        paciente.getNombre(),
                        paciente.getApellido(),
                        cita.getFecha_cita(),
                        cita.getHora_cita(),
                        nombresDoctoresAsignados
                );
                emailService.enviarCorreo(correoUsuario, asunto, mensajeUsuario);
                System.out.println("Correo enviado al usuario: " + correoUsuario);
            }

        } catch (Exception e) {
            System.err.println("Error al enviar correo de confirmación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
