package com.mayadent.MAYADENTBD.serviceImpl;

import com.mayadent.MAYADENTBD.dao.CitaDao;
import com.mayadent.MAYADENTBD.entity.Cita;
import com.mayadent.MAYADENTBD.entity.Paciente;
import com.mayadent.MAYADENTBD.entity.Usuario;
import com.mayadent.MAYADENTBD.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaDao citaDao;
    @Autowired
    private EmailNotificacionService emailNotificacionService;

    @Override
    public Cita create(Cita c) {
        Cita nuevaCita = citaDao.create(c);

        Usuario doctor = c.getUsuario();
        Paciente paciente = c.getPaciente();

        emailNotificacionService.sendMail(
                paciente.getCorreo(),
                "Nueva cita programada",
                "Estimado/a " + paciente.getNombre() + ",\n\n" +
                        "El Dr. " + doctor.getNombre() + " " + doctor.getApellido() +
                        " te ha programado una cita para el " +
                        c.getFecha_cita() + " a las " + c.getHora_cita() + ".\n\n" +
                        "Descripción: " + c.getDescripcion() + "\n\n" +
                        "Atentamente,\nClínica Mayadent."
        );

        emailNotificacionService.sendMail(
                doctor.getCorreo(),
                "Nueva cita registrada",
                "Has registrado una cita con el paciente " +
                        paciente.getNombre() + " " + paciente.getApellido() +
                        " para el " + c.getFecha_cita() + " a las " + c.getHora_cita() + "."
        );

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
