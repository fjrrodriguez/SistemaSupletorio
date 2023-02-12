package com.supletorio.gestion.citas.services;

import com.supletorio.gestion.citas.dto.CitaDto;
import com.supletorio.gestion.citas.dto.HorarioDisponibilidadDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasService implements ICitasService {
    @Override
    public String establecerHorarioDoctor(HorarioDisponibilidadDto horario) {
        return null;
    }

    @Override
    public String agendarCitaMedica(CitaDto cita) {
        return null;
    }

    @Override
    public String actualizarEstadoCita(CitaDto cita, Integer idCita) {
        return null;
    }

    @Override
    public List<CitaDto> listarHistorialMedicoPaciente(Integer pacienteId) {
        return null;
    }
}

