package com.supletorio.gestion.citas.services;

import com.supletorio.gestion.citas.dto.MedicoDto;
import com.supletorio.gestion.citas.dto.PacienteDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;

import java.util.List;

public interface IPersonasService {

    public RespuestaHttpDto crearPaciente(PacienteDto paciente);

    public List<PacienteDto> obtenerPacientes();

    public List<MedicoDto> obtenerMedicos();

    public RespuestaHttpDto actualizarPaciente(PacienteDto paciente, Integer id);

    public RespuestaHttpDto eliminarPaciente(Integer id);
}
