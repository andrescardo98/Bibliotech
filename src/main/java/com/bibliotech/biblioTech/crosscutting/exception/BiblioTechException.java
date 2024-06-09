package com.bibliotech.biblioTech.crosscutting.exception;

import com.bibliotech.biblioTech.crosscutting.exception.enumerator.PlaceException;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.crosscutting.util.UtilText;
import jdk.jshell.execution.Util;

public class BiblioTechException extends RuntimeException{

    private static final long serialVersionUUID = -5050614833514406883L;

    private PlaceException place;
    private Throwable rootException;
    private String userMessage;
    private String technicalMessage;
    private boolean hasRootException;

    protected BiblioTechException(final PlaceException place, final Throwable rootException, final String userMessage,
                                  final String technicalMessage){
        setPlace(place);
        setRootException(rootException);
        setUserMessage(userMessage);
        setTechnicalMessage(technicalMessage);
        setHasRootException(hasRootException);
    }

    public static final BiblioTechException create(final PlaceException place, final Throwable rootException, final String userMessage,
                                                   final String technicalMessage){
        return new BiblioTechException(place, rootException, userMessage, technicalMessage);
    }

    public static final long getSerialVersionuuid() {
        return serialVersionUUID;
    }

    public PlaceException getPlace() {
        return place;
    }

    public Throwable getRootException() {
        return rootException;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }

    public boolean isHasRootException() {
        return hasRootException;
    }

    public void setPlace(PlaceException place) {
        this.place = UtilObject.getDefaultValue(place, PlaceException.GENERAL);
    }

    public void setRootException(Throwable rootException) {
        setHasRootException(!UtilObject.isNull(rootException));
        this.rootException = UtilObject.getDefaultValue(rootException, new Exception());
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = UtilText.applyTrim(userMessage);
    }

    public void setTechnicalMessage(String technicalMessage) {
        this.technicalMessage = UtilText.applyTrim(technicalMessage);
    }

    public void setHasRootException(boolean hasRootException) {
        this.hasRootException = hasRootException;
    }
}
