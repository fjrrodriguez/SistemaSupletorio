package com.supletorio.gestion.citas.services;


import com.supletorio.gestion.citas.dto.CitaDto;
import com.supletorio.gestion.citas.dto.HorarioDisponibilidadDto;

import java.util.List;

public interface ICitasService {
    public String establecerHorarioDoctor(HorarioDisponibilidadDto horario);

    public String agendarCitaMedica(CitaDto cita);

    public String actualizarEstadoCita(CitaDto cita, Integer idCita);

    public List<CitaDto> listarHistorialMedicoPaciente(Integer pacienteId);
}