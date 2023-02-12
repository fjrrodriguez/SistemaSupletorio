package com.supletorio.gestion.citas.services;

import com.supletorio.gestion.citas.dto.MedicoDto;
import com.supletorio.gestion.citas.dto.PacienteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonasService implements IPersonasService {
    @Override
    public String crearPaciente(PacienteDto paciente) {
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
    public String actualizarPaciente(PacienteDto paciente, Integer id) {
        return null;
    }

    @Override
    public String eliminarPaciente(Integer id) {
        return null;
    }
}

