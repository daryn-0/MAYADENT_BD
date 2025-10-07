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
@Table(name = "inventaros")
@Builder
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "unidad_medida")
    private String unidad_medida;
    @Column(name = "costo_unitario")
    private double costo_unitario;
    @Column(name = "fecha_vencimiento")
    private Date fecha_vencimiento;
    @Column(name = "estado")
    private char estado;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "inventario")
    @JsonIgnore
    private Set<UsoInsumos> usoInsumo;
}
