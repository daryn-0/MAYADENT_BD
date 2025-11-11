package com.mayadent.MAYADENTBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cita_tratamientos")
@Builder
public class Cita_Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "costo_final")
    private double costo_final;
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "id_tratamiento", nullable = false)
    private Tratamiento tratamiento;
}
