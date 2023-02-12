package com.supletorio.gestion.citas.repository;

import com.supletorio.gestion.citas.dto.CitaDto;
import com.supletorio.gestion.citas.dto.HorarioDisponibilidadDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class CitasRepository implements ICitasRepository {
    public static String HORARIO_REGISTRADO_CON_EXITO = "Se ha registrado con exito el horario!";
    public static String ERROR_REGISTRANDO_EL_HORARIO = "NO ES POSIBLE REGISTRAR EL HORARIO DEL MEDICO";

    public static String CITA_REGISTRADA_CON_EXITO = "Cita registrada con exito";
    public static String FRANJA_NO_DISPONIBLE = "La franja ya se encuentra ocupada o no se puede repetir ese ID de horario";

    private Set<HorarioDisponibilidadDto> horarioDisponibilidadMedicos;

    private List<CitaDto> listadoCitas;

    @PostConstruct
    public void postConstruct() {
        this.horarioDisponibilidadMedicos = new HashSet<>();
        this.listadoCitas = new ArrayList<>();
    }

    @Override
    public RespuestaHttpDto establecerHorarioMedico(HorarioDisponibilidadDto horario) {
        RespuestaHttpDto respuesta = new RespuestaHttpDto();
        try {
            // Si la franja esta disponible, va permitir registrarlo en el horario
            if (validarRegistroHorarioMedico(horario)) {
                this.horarioDisponibilidadMedicos.add(horario);
                respuesta.setMensaje(HORARIO_REGISTRADO_CON_EXITO);
                respuesta.setEstadoHttp(HttpStatus.CREATED);
            } else {
                respuesta.setMensaje(FRANJA_NO_DISPONIBLE);
                respuesta.setEstadoHttp(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            respuesta.setMensaje(ERROR_REGISTRANDO_EL_HORARIO);
            respuesta.setEstadoHttp(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public boolean validarRegistroHorarioMedico(HorarioDisponibilidadDto horario) {
        /*Se valida si el ID del horario se encuentra repetido o el medico que trata de registrar
         el ya tiene una franja ocupada en ese dia
         */
        // TODO mejorar validacion flanja horario
        HorarioDisponibilidadDto horarioTemp = this.horarioDisponibilidadMedicos.stream().filter(ob -> ob.getId().equals(horario.getId()) || ob.getFecha().equals(horario.getFecha()) && (ob.getHoraInicio().equals(horario.getHoraInicio()) || ob.getHoraFinal().equals(horario.getHoraFinal()))).findAny().orElse(null);

        // Si ya se encuentra una franja ocupada o el horarioID ya se encuentra registrado retornara false
        if (horarioTemp != null) {
            return false;
        }
        // Si la franja esta disponible se retornara true
        return true;
    }


    @Override
    public List<HorarioDisponibilidadDto> consultarHorarioMedico(Integer idMedico) {
        List<HorarioDisponibilidadDto> horarioLista = this.horarioDisponibilidadMedicos.stream().filter(c -> c.getMedico().getId().equals(idMedico)).collect(Collectors.toList());
        return horarioLista;
    }

    @Override
    public RespuestaHttpDto agendarCitaMedica(CitaDto cita) {
        RespuestaHttpDto respuesta = new RespuestaHttpDto();

        LocalDateTime fechaSitema = LocalDateTime.now();
        cita.setFechaRegistro(fechaSitema.toLocalDate());
        cita.setHoraRegistro(fechaSitema.toLocalTime());
        cita.setFechaModificacion(fechaSitema.toLocalDate());
        cita.setHoraModificacion(fechaSitema.toLocalTime());
        // TODO falta validar registro de cita medica (solo horarios disponibles)
        respuesta.setMensaje(CITA_REGISTRADA_CON_EXITO);
        respuesta.setEstadoHttp(HttpStatus.CREATED);
        this.listadoCitas.add(cita);
        return respuesta;
    }
}
