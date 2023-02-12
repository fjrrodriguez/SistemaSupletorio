package com.supletorio.gestion.citas.controllers;

import com.supletorio.gestion.citas.dto.MedicoDto;
import com.supletorio.gestion.citas.dto.PacienteDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;
import com.supletorio.gestion.citas.services.IPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonasController {
    public static String PACIENTES_NO_DISPONIBLES = "Actualmente no se encuentran pacientes en el sistema";

    public static String MEDICOS_NO_DISPONIBLES = "Actualmente no se encuentran medicos en el sistema";

    @Autowired
    private IPersonasService personasService;

    @PostMapping("/crear-paciente")
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDto paciente) {
        RespuestaHttpDto respuesta = personasService.crearPaciente(paciente);
        return new ResponseEntity<String>(respuesta.getMensaje(), respuesta.getEstadoHttp());
    }

    @GetMapping("/listar-pacientes")
    public ResponseEntity<?> obtenerPacientes() {
        List<PacienteDto> pacientesDisponibles = personasService.obtenerPacientes();
        if (pacientesDisponibles == null || pacientesDisponibles.size() == 0) {
            return new ResponseEntity<String>(PACIENTES_NO_DISPONIBLES, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<PacienteDto>>(pacientesDisponibles, HttpStatus.OK);
    }

    @GetMapping("/listar-medicos")
    public ResponseEntity<?> obtenerMedicos() {
        List<MedicoDto> medicosDisponibles = personasService.obtenerMedicos();
        if (medicosDisponibles == null || medicosDisponibles.size() == 0) {
            return new ResponseEntity<String>(MEDICOS_NO_DISPONIBLES, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<MedicoDto>>(medicosDisponibles, HttpStatus.OK);
    }

    @PutMapping("/actualizar-paciente")
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDto paciente) {
        RespuestaHttpDto respuesta = personasService.actualizarPaciente(paciente);
        return new ResponseEntity<String>(respuesta.getMensaje(), respuesta.getEstadoHttp());
    }

    @DeleteMapping("/eliminar-paciente/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Integer id) {
        RespuestaHttpDto respuesta = personasService.eliminarPaciente(id);
        return new ResponseEntity<String>(respuesta.getMensaje(), respuesta.getEstadoHttp());
    }
}
