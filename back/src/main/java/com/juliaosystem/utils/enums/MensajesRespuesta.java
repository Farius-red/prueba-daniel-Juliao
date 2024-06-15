package com.juliaosystem.utils.enums;




public enum MensajesRespuesta {
    CREADO("Creado(a) correctamente"),
    GET("Se obtuvieron datos correctamente"),
    ACTUALIZADO("Actualizado correctamente"),
    FALLO("Algo salió mal"),
    NO_ENCONTRADO("Verifique los datos del cliente no se encontro el id de ese cliente"),
    USER_ISFOUND("Ya se encuentra registrado"),

    DELETED("Eliminado(a) correctamente");

    private final String mensaje;

    MensajesRespuesta(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
