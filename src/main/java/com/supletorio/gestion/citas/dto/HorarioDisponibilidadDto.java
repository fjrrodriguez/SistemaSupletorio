package com.supletorio.gestion.citas.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class HorarioDisponibilidadDto {
    private Integer id;

    private MedicoDto medico;

    private LocalDate fecha;

    private LocalTime horaInicio;

    private LocalTime horaFinal;

    public HorarioDisponibilidadDto() {
    }

    public HorarioDisponibilidadDto(Integer id, MedicoDto medico, LocalDate fecha, LocalTime horaInicio, LocalTime horaFinal) {
        this.id = id;
        this.medico = medico;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MedicoDto getMedico() {
        return medico;
    }

    public void setMedico(MedicoDto medico) {
        this.medico = medico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }
}

