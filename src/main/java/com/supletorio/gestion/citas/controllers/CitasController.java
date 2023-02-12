package com.supletorio.gestion.citas.controllers;

import com.supletorio.gestion.citas.dto.*;
import com.supletorio.gestion.citas.services.ICitasService;
import com.supletorio.gestion.citas.services.IPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitasController {

    public static String HISTORIAL_MEDICO_NO_DISPONIBLE = "El paciente no tiene historial medico";

    public static String ERROR_HORARIO_MEDICO = "El medico con ese ID no tiene ningun horario disponible";

    public static String MEDICO_NO_EXISTE = "El medico con ese ID no existe en el sistema";

    public static String PACIENTE_NO_ENCONTRADO = "El paciente con ese ID no se encuentra registrado en el sistema";

    @Autowired
    private ICitasService citasService;

    @Autowired
    private IPersonasService personasService;

    @PostMapping("/establecer-horario-medico")
    ResponseEntity<?> establecerHorarioMedico(@RequestBody HorarioDisponibilidadDto horario) {
        RespuestaHttpDto respuesta = citasService.establecerHorarioMedico(horario);
        return new ResponseEntity<String>(respuesta.getMensaje(), respuesta.getEstadoHttp());
    }

    @GetMapping("/consultar-horario-medico/{idMedico}")
    ResponseEntity<?> consultarHorarioMedico(@PathVariable Integer idMedico) {
        // Se consulta el listado de medicos disponibles
        List<MedicoDto> listaMedicos = personasService.obtenerMedicos();

        // Se valida si existe un medico con ese ID
        MedicoDto medicoTemp = listaMedicos
                .stream()
                .filter(value -> value.getId().equals(idMedico))
                .findAny()
                .orElse(null);

        // Si existe un medico con ese ID se retornara la lista o el mensaje que no tiene horario disponible
        if (medicoTemp != null) {
            List<HorarioDisponibilidadDto> horarioDisponibilidadMedico = citasService.consultarHorarioMedico(idMedico);
            if (horarioDisponibilidadMedico == null || horarioDisponibilidadMedico.size() == 0) {
                return new ResponseEntity<String>(ERROR_HORARIO_MEDICO, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<HorarioDisponibilidadDto>>(horarioDisponibilidadMedico, HttpStatus.OK);
        }
        // en caso de que el id del medico que pasa el usuairo NO existe retornamos mensaje de error...
        return new ResponseEntity<String>(MEDICO_NO_EXISTE, HttpStatus.NOT_FOUND);
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
        // Validamos si el paciante existe....
        PacienteDto pacienteTemp = personasService.obtenerPacientes()
                .stream()
                .filter(p -> p.getId().equals(pacienteId))
                .findFirst()
                .orElse(null);

        // Si existe el paciente existe retornamos el historial o si no posee historial medico en el sistema
        if (pacienteTemp != null) {
            List<CitaDto> historialMedico = citasService.listarHistorialMedicoPaciente(pacienteId);
            // Si el paciante NO tiene historial medico retornamos el mensaje de error
            if (historialMedico == null || historialMedico.size() == 0) {
                return new ResponseEntity<String>(HISTORIAL_MEDICO_NO_DISPONIBLE, HttpStatus.NOT_FOUND);
            }
            // en caso contrario si el paciente si tiene historial medico retornamos el historial de el
            return new ResponseEntity<List<CitaDto>>(historialMedico, HttpStatus.OK);
        }
        // En el caso de que el empleado no exista retornamos mensaje de error....
        return new ResponseEntity<String>(PACIENTE_NO_ENCONTRADO, HttpStatus.NOT_FOUND);
    }
}
