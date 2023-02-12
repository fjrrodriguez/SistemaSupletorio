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
}

