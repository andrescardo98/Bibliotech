package com.bibliotech.biblioTech.crosscutting.exception.concrete;

import com.bibliotech.biblioTech.crosscutting.exception.BiblioTechException;
import com.bibliotech.biblioTech.crosscutting.exception.enumerator.PlaceException;

public class ServiceBibliotechException extends BiblioTechException {

    private static final long serialVersionUUID = 2765757041071477495L;

    protected ServiceBibliotechException(Throwable rootException, String userMessage, String technicalMessage) {
        super(PlaceException.SERVICE, rootException, userMessage, technicalMessage);
    }

    public static final BiblioTechException create(final String userMessage){
        return new ServiceBibliotechException(null, userMessage, userMessage);
    }

    public static final BiblioTechException create(final String userMessage, final String technicalMessage){
        return new ServiceBibliotechException(null, userMessage, technicalMessage);
    }

    public static final BiblioTechException create(final Throwable rootException , final String userMessage,
                                                   final String technicalMessage){
        return new ServiceBibliotechException(rootException, userMessage, technicalMessage);
    }
}
