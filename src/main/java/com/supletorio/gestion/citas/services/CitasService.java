package com.supletorio.gestion.citas.services;

import com.supletorio.gestion.citas.dto.CitaDto;
import com.supletorio.gestion.citas.dto.HorarioDisponibilidadDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;
import com.supletorio.gestion.citas.repository.ICitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasService implements ICitasService {

    @Autowired
    private ICitasRepository citasRepository;

    @Override
    public RespuestaHttpDto establecerHorarioMedico(HorarioDisponibilidadDto horario) {
        return citasRepository.establecerHorarioMedico(horario);
    }

    @Override
    public List<HorarioDisponibilidadDto> consultarHorarioMedico(Integer idMedico) {
        return citasRepository.consultarHorarioMedico(idMedico);
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

