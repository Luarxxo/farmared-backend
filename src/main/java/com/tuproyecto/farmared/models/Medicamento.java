package com.tuproyecto.farmared.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicamentos")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_comercial", nullable = false, length = 100)
    private String nombreComercial;

    @Column(name = "principio_activo", nullable = false, length = 100)
    private String principioActivo;

    @Column(nullable = false, length = 50)
    private String concentracion;

    @Column(length = 100)
    private String presentacion;

    @Column(length = 100)
    private String laboratorio;

    @Column(name = "codigo_barras", unique = true, length = 50)
    private String codigoBarras;

    @Column(nullable = false, length = 50)
    private String lote;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "fecha_caducidad", nullable = false)
    private LocalDate fechaCaducidad;

    public Medicamento() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreComercial() { return nombreComercial; }
    public void setNombreComercial(String nombreComercial) { this.nombreComercial = nombreComercial; }
    public String getPrincipioActivo() { return principioActivo; }
    public void setPrincipioActivo(String principioActivo) { this.principioActivo = principioActivo; }
    public String getConcentracion() { return concentracion; }
    public void setConcentracion(String concentracion) { this.concentracion = concentracion; }
    public String getPresentacion() { return presentacion; }
    public void setPresentacion(String presentacion) { this.presentacion = presentacion; }
    public String getLaboratorio() { return laboratorio; }
    public void setLaboratorio(String laboratorio) { this.laboratorio = laboratorio; }
    public String getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(String codigoBarras) { this.codigoBarras = codigoBarras; }
    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public LocalDate getFechaCaducidad() { return fechaCaducidad; }
    public void setFechaCaducidad(LocalDate fechaCaducidad) { this.fechaCaducidad = fechaCaducidad; }
}