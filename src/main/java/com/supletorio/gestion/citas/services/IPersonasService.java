package com.supletorio.gestion.citas.services;

import com.supletorio.gestion.citas.dto.MedicoDto;
import com.supletorio.gestion.citas.dto.PacienteDto;

import java.util.List;

public interface IPersonasService {

    public String crearPaciente(PacienteDto paciente);

    public List<PacienteDto> obtenerPacientes();

    public List<MedicoDto> obtenerMedicos();

    public String actualizarPaciente(PacienteDto paciente, Integer id);

    public String eliminarPaciente(Integer id);
}
