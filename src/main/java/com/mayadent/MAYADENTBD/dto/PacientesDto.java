package com.mayadent.MAYADENTBD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacientesDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private String dni;
    private String genero;
    private Date fechaNacimiento;
}