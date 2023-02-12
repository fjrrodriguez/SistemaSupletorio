package com.supletorio.gestion.citas.controllers;

import com.supletorio.gestion.citas.dto.CitaDto;
import com.supletorio.gestion.citas.dto.HorarioDisponibilidadDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citas")
public class CitasController {

    @PostMapping("/establecer-horario-doctor")
    ResponseEntity<?> establecerHorarioDoctor(@RequestBody HorarioDisponibilidadDto horario) {
        return null;
    }

    @PostMapping("/agendar-cita-medica")
    ResponseEntity<?> agendarCitaMedica(@RequestBody CitaDto cita) {
        return null;
    }

    @PutMapping("/actualizar-estado-cita/{idCita}")
    ResponseEntity<?> actualizarEstadoCita(@RequestBody CitaDto cita, @PathVariable Integer idCita) {
        return null;
    }

    @GetMapping("/listar-historial-medico-paciente/{pacienteId}")
    ResponseEntity<?> listarHistorialMedicoPaciente(@PathVariable Integer pacienteId) {
        return null;
    }
}
