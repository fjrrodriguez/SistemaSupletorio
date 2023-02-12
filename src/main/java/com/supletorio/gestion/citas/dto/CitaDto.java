package com.supletorio.gestion.citas.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDto {
    private Integer id;

    private TipoCitaDto tipoCita;

    private MedicoDto medico;

    private PacienteDto paciente;

    private String estado;

    private String descripcion;

    private LocalDate fechaRegistro;

    private LocalTime horaRegistro;

    private LocalDate fechaModificacion;

    private LocalTime horaModificacion;

    public CitaDto() {
    }

    public CitaDto(Integer id, TipoCitaDto tipoCita, MedicoDto medico, PacienteDto paciente, String estado, String descripcion, LocalDate fechaRegistro, LocalTime horaRegistro, LocalDate fechaModificacion, LocalTime horaModificacion) {
        this.id = id;
        this.tipoCita = tipoCita;
        this.medico = medico;
        this.paciente = paciente;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.fechaModificacion = fechaModificacion;
        this.horaModificacion = horaModificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoCitaDto getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(TipoCitaDto tipoCita) {
        this.tipoCita = tipoCita;
    }

    public MedicoDto getMedico() {
        return medico;
    }

    public void setMedico(MedicoDto medico) {
        this.medico = medico;
    }

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalTime getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(LocalTime horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public LocalTime getHoraModificacion() {
        return horaModificacion;
    }

    public void setHoraModificacion(LocalTime horaModificacion) {
        this.horaModificacion = horaModificacion;
    }
}
