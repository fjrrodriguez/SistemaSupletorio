package com.supletorio.gestion.citas.services;

import com.supletorio.gestion.citas.dto.MedicoDto;
import com.supletorio.gestion.citas.dto.PacienteDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;
import com.supletorio.gestion.citas.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonasService implements IPersonasService {

    @Autowired
    private IPersonaRepository personaRepository;

    @Override
    public RespuestaHttpDto crearPaciente(PacienteDto paciente) {
        return personaRepository.crearPaciente(paciente);
    }

    @Override
    public List<PacienteDto> obtenerPacientes() {
        return personaRepository.obtenerPacientes();
    }

    @Override
    public List<MedicoDto> obtenerMedicos() {
        return personaRepository.obtenerMedicos();
    }

    @Override
    public RespuestaHttpDto actualizarPaciente(PacienteDto paciente) {
        return personaRepository.actualizarPaciente(paciente);
    }

    @Override
    public RespuestaHttpDto eliminarPaciente(Integer id) {
        return personaRepository.eliminarPaciente(id);
    }
}
