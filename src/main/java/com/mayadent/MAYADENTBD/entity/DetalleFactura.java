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
@Table(name = "detalle_factura")
@Builder
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "subtotal")
    private double subtotal;
    @Column(name = "precio_unitario")
    private double precio_unitario;
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura factura;
}
