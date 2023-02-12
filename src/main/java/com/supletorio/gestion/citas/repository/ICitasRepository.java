package com.supletorio.gestion.citas.repository;

import com.supletorio.gestion.citas.dto.CitaDto;
import com.supletorio.gestion.citas.dto.HorarioDisponibilidadDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;

import java.util.List;

public interface ICitasRepository {
    public RespuestaHttpDto establecerHorarioMedico(HorarioDisponibilidadDto horario);

    public List<HorarioDisponibilidadDto> consultarHorarioMedico(Integer idMedico);

    public RespuestaHttpDto agendarCitaMedica(CitaDto cita);

    public List<CitaDto> listarHistorialMedicoPaciente(Integer pacienteId);
}

