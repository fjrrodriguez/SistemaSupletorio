package com.supletorio.gestion.citas.services;

import com.supletorio.gestion.citas.dto.MedicoDto;
import com.supletorio.gestion.citas.dto.PacienteDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonasService implements IPersonasService {
    @Override
    public RespuestaHttpDto crearPaciente(PacienteDto paciente) {
        return null;
    }

    @Override
    public List<PacienteDto> obtenerPacientes() {
        return null;
    }

    @Override
    public List<MedicoDto> obtenerMedicos() {
        return null;
    }

    @Override
    public RespuestaHttpDto actualizarPaciente(PacienteDto paciente, Integer id) {
        return null;
    }

    @Override
    public RespuestaHttpDto eliminarPaciente(Integer id) {
        return null;
    }
}
