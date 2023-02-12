package com.supletorio.gestion.citas.services;

import com.supletorio.gestion.citas.dto.CitaDto;
import com.supletorio.gestion.citas.dto.HorarioDisponibilidadDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasService implements ICitasService {

    @Override
    public RespuestaHttpDto establecerHorarioDoctor(HorarioDisponibilidadDto horario) {
        return null;
    }

    @Override
    public RespuestaHttpDto agendarCitaMedica(CitaDto cita) {
        return null;
    }

    @Override
    public RespuestaHttpDto actualizarEstadoCita(CitaDto cita, Integer idCita) {
        return null;
    }

    @Override
    public List<CitaDto> listarHistorialMedicoPaciente(Integer pacienteId) {
        return null;
    }
}
