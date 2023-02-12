package com.supletorio.gestion.citas.dto;

import org.springframework.http.HttpStatus;

public class RespuestaHttpDto {
    private String mensaje;

    private HttpStatus estadoHttp;

    public RespuestaHttpDto() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HttpStatus getEstadoHttp() {
        return estadoHttp;
    }

    public void setEstadoHttp(HttpStatus estadoHttp) {
        this.estadoHttp = estadoHttp;
    }
}

