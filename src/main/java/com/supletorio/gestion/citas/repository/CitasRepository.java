package com.supletorio.gestion.citas.repository;

import com.supletorio.gestion.citas.dto.HorarioDisponibilidadDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class CitasRepository implements ICitasRepository {
    public static String HORARIO_REGISTRADO_CON_EXITO = "Se ha registrado con exito el horario!";
    public static String ERROR_REGISTRANDO_EL_HORARIO = "NO ES POSIBLE REGISTRAR EL HORARIO DEL MEDICO";

    private Set<HorarioDisponibilidadDto> horarioDisponibilidadMedicos;

    @PostConstruct
    public void postConstruct() {
        this.horarioDisponibilidadMedicos = new HashSet<>();
    }

    @Override
    public RespuestaHttpDto establecerHorarioMedico(HorarioDisponibilidadDto horario) {
        RespuestaHttpDto respuesta = new RespuestaHttpDto();
        try {
            this.horarioDisponibilidadMedicos.add(horario);
            respuesta.setMensaje(HORARIO_REGISTRADO_CON_EXITO);
            respuesta.setEstadoHttp(HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex);
            respuesta.setMensaje(ERROR_REGISTRANDO_EL_HORARIO);
            respuesta.setEstadoHttp(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @Override
    public List<HorarioDisponibilidadDto> consultarHorarioMedico(Integer idMedico) {
        List<HorarioDisponibilidadDto> horarioLista = this.horarioDisponibilidadMedicos.stream().filter(c -> c.getMedico().getId().equals(idMedico)).collect(Collectors.toList());
        return horarioLista;
    }
}

