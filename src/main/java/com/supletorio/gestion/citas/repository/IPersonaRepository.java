package com.supletorio.gestion.citas.repository;


import com.supletorio.gestion.citas.dto.MedicoDto;
import com.supletorio.gestion.citas.dto.PacienteDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;

import java.util.List;

public interface IPersonaRepository {
    public RespuestaHttpDto crearPaciente(PacienteDto paciente);

    public List<PacienteDto> obtenerPacientes();

    public List<MedicoDto> obtenerMedicos();

    public RespuestaHttpDto actualizarPaciente(PacienteDto paciente);

    public RespuestaHttpDto eliminarPaciente(Integer id);
}
