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
        return citasRepository.agendarCitaMedica(cita);
    }

    @Override
    public RespuestaHttpDto actualizarEstadoCita(Integer idCita, String estadoCita) {
        return citasRepository.actualizarEstadoCita(idCita, estadoCita);
    }

    @Override
    public List<CitaDto> listarHistorialMedicoPaciente(Integer pacienteId) {
        return citasRepository.listarHistorialMedicoPaciente(pacienteId);
    }
}



