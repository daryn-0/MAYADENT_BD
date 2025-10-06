package com.mayadent.MAYADENTBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
@Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni")
    private String dni;
    @Column(name = "correo")
    private String correo;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "genero")
    private String genero;
    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;
    @Column(name = "estado")
    private String estado;
}
