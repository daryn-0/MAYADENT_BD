package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.CitaDao;
import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.entity.Paciente;
import com.mayadent.MAYADENTBD.entity.Usuario;
import com.mayadent.MAYADENTBD.service.CitaService;
import com.mayadent.MAYADENTBD.service.EmailService;
import com.mayadent.MAYADENTBD.service.PacienteService;
import com.mayadent.MAYADENTBD.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                String correoDoctor = usuario.getCorreo();

                System.out.println("Correo Paciente: " + correoPaciente);
                System.out.println("Correo Doctor: " + correoDoctor);

                String asunto = "Confirmación de Cita Odontológica";

                String mensajePaciente = String.format(
                        "Estimado/a %s %s,\n\nSu cita ha sido registrada exitosamente.\nFecha: %s\nHora: %s\nDoctor: %s %s\n\nClínica Odontológica Unión",
                        paciente.getNombre(),
                        paciente.getApellido(),
                        nuevaCita.getFecha_cita(),
                        nuevaCita.getHora_cita(),
                        usuario.getNombre(),
                        usuario.getApellido()
                );

                String mensajeDoctor = String.format(
                        "Estimado/a Dr(a). %s %s,\n\nSe le ha asignado una nueva cita.\nPaciente: %s %s\nFecha: %s\nHora: %s\n\nClínica Odontológica Unión",
                        usuario.getNombre(),
                        usuario.getApellido(),
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

                if (correoDoctor != null && !correoDoctor.isBlank()) {
                    emailService.enviarCorreo(correoDoctor, asunto, mensajeDoctor);
                } else {
                    System.err.println("Doctor sin correo registrado, no se envió notificación.");
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
        return citaDao.update(c);
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
}
