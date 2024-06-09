package com.bibliotech.biblioTech.crosscutting.util;

public class UtilObject {

    private UtilObject() {
        super();
    }

    public static final <O> boolean isNull(final O object) {
        return object == null;
    }

    public static final <O> O getDefaultValue(final O object, final O defaultValue) {
        return isNull(object) ? defaultValue : object;
    }
}
