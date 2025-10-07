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
@Table(name = "facturas")
@Builder
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha_emison")
    private Date fecha_emmision;
    @Column(name = "monto_total")
    private double monto_total;
    @Column(name = "estado")
    private Long estado;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "factura")
    @JsonIgnore
    private Set<DetalleFactura> detalleFactura;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_estado_pago", nullable = false)
    private EstadoPago estadoPago;

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;
}
