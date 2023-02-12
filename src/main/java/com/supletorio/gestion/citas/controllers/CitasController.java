package com.supletorio.gestion.citas.controllers;

import com.supletorio.gestion.citas.dto.CitaDto;
import com.supletorio.gestion.citas.dto.HorarioDisponibilidadDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;
import com.supletorio.gestion.citas.services.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitasController {

    public static String HISTORIAL_MEDICO_NO_DISPONIBLE = "El paciente no tiene historial medico";

    @Autowired
    private CitasService citasService;

    @PostMapping("/establecer-horario-doctor")
    ResponseEntity<?> establecerHorarioDoctor(@RequestBody HorarioDisponibilidadDto horario) {
        RespuestaHttpDto respuesta = citasService.establecerHorarioDoctor(horario);
        return new ResponseEntity<String>(respuesta.getMensaje(), respuesta.getEstadoHttp());
    }

    @PostMapping("/agendar-cita-medica")
    ResponseEntity<?> agendarCitaMedica(@RequestBody CitaDto cita) {
        RespuestaHttpDto respuesta = citasService.agendarCitaMedica(cita);
        return new ResponseEntity<String>(respuesta.getMensaje(), respuesta.getEstadoHttp());
    }

    @PutMapping("/actualizar-estado-cita/{idCita}")
    ResponseEntity<?> actualizarEstadoCita(@RequestBody CitaDto cita, @PathVariable Integer idCita) {
        RespuestaHttpDto respuesta = citasService.actualizarEstadoCita(cita, idCita);
        return new ResponseEntity<String>(respuesta.getMensaje(), respuesta.getEstadoHttp());
    }

    @GetMapping("/listar-historial-medico-paciente/{pacienteId}")
    ResponseEntity<?> listarHistorialMedicoPaciente(@PathVariable Integer pacienteId) {
        List<CitaDto> historialMedico = citasService.listarHistorialMedicoPaciente(pacienteId);
        // Si el paciante NO tiene historial medico retornamos el mensaje de error
        if (historialMedico == null || historialMedico.size() == 0) {
            return new ResponseEntity<String>(HISTORIAL_MEDICO_NO_DISPONIBLE, HttpStatus.NOT_FOUND);
        }
        // en caso contrario si el paciente si tiene historial medico retornamos el historial de el
        return new ResponseEntity<List<CitaDto>>(historialMedico, HttpStatus.OK);
    }
}
