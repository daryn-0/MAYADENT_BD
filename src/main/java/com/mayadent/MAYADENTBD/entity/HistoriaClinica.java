package com.mayadent.MAYADENTBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historias_clinicas")
@Builder
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha_emision")
    private Date fecha_emision;
    @Column(name = "monto_total")
    private double monto_total;
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;
}
