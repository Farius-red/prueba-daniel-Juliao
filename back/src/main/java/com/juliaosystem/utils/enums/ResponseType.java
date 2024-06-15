package com.juliaosystem.utils.enums;


import org.springframework.http.HttpStatus;

public enum ResponseType {

    CREATED(1, MensajesRespuesta.CREADO.getMensaje(), true, HttpStatus.CREATED),
    UPDATED(2, MensajesRespuesta.ACTUALIZADO.getMensaje(), true, HttpStatus.OK),
    FALLO(3, MensajesRespuesta.FALLO.getMensaje(), false, HttpStatus.INTERNAL_SERVER_ERROR),
    NO_ENCONTRADO(4,MensajesRespuesta.NO_ENCONTRADO.getMensaje(),false, HttpStatus.OK),
    USER_ISFOUND(5, MensajesRespuesta.USER_ISFOUND.getMensaje(), false, HttpStatus.OK),
    DELETED(9,MensajesRespuesta.DELETED.getMensaje(),true, HttpStatus.OK),
    GET(10,MensajesRespuesta.GET.getMensaje(),true,HttpStatus.OK);

    private final int code;

    private final String message;
    private final boolean isRta;
    private final HttpStatus httpStatus;

    ResponseType(int code, String message, boolean isRta, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.isRta = isRta;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

    public boolean isRta() {
        return isRta;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public  static  ResponseType fromMessage(String message){
        for (ResponseType responseType : ResponseType.values()) {
            if (responseType.message.equalsIgnoreCase(message)) {
                return responseType;
            }
        }
        return ResponseType.FALLO;
    }
    public static ResponseType fromCode(int code) {
        for (ResponseType responseType : ResponseType.values()) {
            if (responseType.code == code) {
                return responseType;
            }
        }
        return null;
    }
}
