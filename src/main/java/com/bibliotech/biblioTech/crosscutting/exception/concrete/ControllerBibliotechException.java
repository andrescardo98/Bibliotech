package com.bibliotech.biblioTech.crosscutting.exception.concrete;

import com.bibliotech.biblioTech.crosscutting.exception.BiblioTechException;
import com.bibliotech.biblioTech.crosscutting.exception.enumerator.PlaceException;

public class ControllerBibliotechException extends BiblioTechException {

    private static final long serialVersionUUID = 2765757041071477495L;

    protected ControllerBibliotechException(Throwable rootException, String userMessage, String technicalMessage) {
        super(PlaceException.CONTROLLER, rootException, userMessage, technicalMessage);
    }

    public static final BiblioTechException create(final String userMessage){
        return new ControllerBibliotechException(null, userMessage, userMessage);
    }

    public static final BiblioTechException create(final String userMessage, final String technicalMessage){
        return new ControllerBibliotechException(null, userMessage, technicalMessage);
    }

    public static final BiblioTechException create(final Throwable rootException , final String userMessage,
                                                   final String technicalMessage){
        return new ControllerBibliotechException(rootException, userMessage, technicalMessage);
    }
}
