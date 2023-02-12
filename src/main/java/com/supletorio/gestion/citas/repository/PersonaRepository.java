package com.supletorio.gestion.citas.repository;

import com.supletorio.gestion.citas.dto.MedicoDto;
import com.supletorio.gestion.citas.dto.PacienteDto;
import com.supletorio.gestion.citas.dto.RespuestaHttpDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonaRepository implements IPersonaRepository {

    public static String PACIENTE_NO_REGISTRADO = "No es posible registrar el paciente, el paciente ya se encuentra registrado";
    public static String PACIENTE_REGISTRADO = "El paciente se ha registrado con exito!";

    public static String PACIENTE_ACTUALIZADO = "El paciente se ha actualizado con exito!";

    public static String PACIENTE_NO_ENCONTRADO = "El paciente con esa identificacion no se encuentra en el sistema";

    public static String PACIENTE_ELIMINADO_CON_EXITO = "El paciente se ha eliminado con exito!";

    public static String OCURRIO_ERROR_INESPERADO = "Ocurrio un error inesperado, comuniquese con el administrador";

    private ArrayList<PacienteDto> listaParientes;

    private HashMap<String, MedicoDto> mapMedicos = new HashMap<>();

    @PostConstruct
    public void postConstruct() {
        this.listaParientes = new ArrayList<>();
        MedicoDto medico1 = new MedicoDto();
        medico1.setId(1);
        medico1.setNombres("Medico name");
        medico1.setApellidos("Medico apellido");
        medico1.setDireccion("Bogota");
        medico1.setTelefono("8721354");
        medico1.setSexo("Masculino");

        MedicoDto medico2 = new MedicoDto();
        medico2.setId(2);
        medico2.setNombres("Medico name 2");
        medico2.setApellidos("Medico apellido 2");
        medico2.setDireccion("Bogota 2");
        medico2.setTelefono("8321356");
        medico2.setSexo("Femenino");
        this.mapMedicos.put("medico 1 ", medico1);
        this.mapMedicos.put("medico 2 ", medico2);
    }

    @Override
    public RespuestaHttpDto crearPaciente(PacienteDto paciente) {
        RespuestaHttpDto respuesta = new RespuestaHttpDto();
        try {
            // Si no existe un paciente con ese id se va añadir
            PacienteDto pacienteTemp = this.listaParientes.stream().filter(value -> value.getId().equals(paciente.getId())).findAny().orElse(null);
            System.out.println("pacienteTemp : " + pacienteTemp);
            if (pacienteTemp == null) {
                this.listaParientes.add(paciente);
                respuesta.setMensaje(PACIENTE_REGISTRADO);
                respuesta.setEstadoHttp(HttpStatus.CREATED);
            } else {
                respuesta.setMensaje(PACIENTE_NO_REGISTRADO);
                respuesta.setEstadoHttp(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            respuesta.setMensaje(OCURRIO_ERROR_INESPERADO);
            respuesta.setEstadoHttp(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public List<PacienteDto> obtenerPacientes() {
        /*
        Imprimimos cada paciente disponible
         */
        System.out.println(" ---- Pacientes disponibles -------");
        this.listaParientes.stream().forEach((pacienteDto -> {
            System.out.println("Id " + pacienteDto.getId());
            System.out.println("Nombres " + pacienteDto.getNombres());
            System.out.println("Apellidos " + pacienteDto.getApellidos());
        }));
        System.out.println(" ----------------------------------");
        return this.listaParientes;
    }

    @Override
    public List<MedicoDto> obtenerMedicos() {
        System.out.println(" ---- Medicos disponibles -------");
        this.mapMedicos.forEach((key, value) -> {
            System.out.println("\n Id " + value.getId());
            System.out.println("Nombres " + value.getNombres());
            System.out.println("Apellidos " + value.getApellidos() + " \n ");
        });
        System.out.println(" ----------------------------------");
        // Convertimos el hashmap a una lista...
        return this.mapMedicos.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public RespuestaHttpDto actualizarPaciente(PacienteDto paciente) {
        RespuestaHttpDto respuesta = new RespuestaHttpDto();
        try {
            PacienteDto pacienteTemp = this.listaParientes.stream().filter(value -> value.getId().equals(paciente.getId())).findAny().orElse(null);

            // Si existe un paciente con ese id se va actualizar la informacion del paciente
            if (pacienteTemp != null) {
                // Se actualizara la informacion de ese paciente
                this.listaParientes.stream().filter(value -> value.getId().equals(paciente.getId())).forEach(p -> {
                    p.setId(paciente.getId());
                    p.setNombres(paciente.getNombres());
                    p.setApellidos(paciente.getApellidos());
                    p.setDireccion(paciente.getDireccion());
                    p.setTelefono(paciente.getTelefono());
                    p.setSexo(paciente.getSexo());
                });
                respuesta.setEstadoHttp(HttpStatus.OK);
                respuesta.setMensaje(PACIENTE_ACTUALIZADO);
            } else {
                // En el caso de que no se encuentre un paciente con ese id se retornara el mensaje de error...
                respuesta.setMensaje(PACIENTE_NO_ENCONTRADO);
                respuesta.setEstadoHttp(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            respuesta.setMensaje(OCURRIO_ERROR_INESPERADO);
            respuesta.setEstadoHttp(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @Override
    public RespuestaHttpDto eliminarPaciente(Integer id) {
        RespuestaHttpDto respuesta = new RespuestaHttpDto();
        try {
            PacienteDto pacienteTemp = this.listaParientes.stream().filter(value -> value.getId().equals(id)).findAny().orElse(null);
            // Si se encuentra un paciente con ese id lo eliminamos de la lista
            if (pacienteTemp != null) {
                this.listaParientes.remove(pacienteTemp);
                respuesta.setEstadoHttp(HttpStatus.OK);
                respuesta.setMensaje(PACIENTE_ELIMINADO_CON_EXITO);
            } else {
                // En el caso de que no se encuentre un paciente con ese id se retornara el mensaje de error...
                respuesta.setMensaje(PACIENTE_NO_ENCONTRADO);
                respuesta.setEstadoHttp(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            respuesta.setMensaje(OCURRIO_ERROR_INESPERADO);
            respuesta.setEstadoHttp(HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}

