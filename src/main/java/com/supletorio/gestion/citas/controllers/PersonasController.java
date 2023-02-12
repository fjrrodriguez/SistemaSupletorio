package com.supletorio.gestion.citas.controllers;

import com.supletorio.gestion.citas.dto.PacienteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personas")
public class PersonasController {

    @PostMapping("/crear-paciente")
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDto paciente) {
        return null;
    }

    @GetMapping("/listar-pacientes")
    public ResponseEntity<?> obtenerPacientes() {
        return null;
    }

    @GetMapping("/listar-medicos")
    public ResponseEntity<?> obtenerMedicos() {
        return null;
    }

    @PutMapping("/actualizar-paciente/{id}")
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDto paciente, @PathVariable Integer id) {
        return null;
    }

    @DeleteMapping("/eliminar-paciente/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Integer id) {
        return null;
    }

}
