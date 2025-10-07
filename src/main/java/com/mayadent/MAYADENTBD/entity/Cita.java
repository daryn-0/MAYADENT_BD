package com.mayadent.MAYADENTBD.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "citas")
@Builder
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha_cita")
    private Date fecha_cita;
    @Column(name = "hora_cita")
    private String hora_cita;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private char estado;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cita")
    @JsonIgnore
    private Set<Factura> factura;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cita")
    @JsonIgnore
    private Set<UsoInsumos> usoInsumo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cita")
    @JsonIgnore
    private Set<HistoriaClinica> historiaClinica;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cita")
    @JsonIgnore
    private Set<Cita_Tratamiento> citaTratamiento;

    @ManyToOne
    @JoinColumn(name = "id_estadi_cita", nullable = false)
    private EstadoCita estadoCita;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
