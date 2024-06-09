package com.bibliotech.biblioTech.crosscutting.util;

public final class UtilText {

    public static final String VACIO = "";
    public static final String PATTERN_SOLO_LETRAS = "^[A-Za-záéíóúÁÉÍÓÚ]+$";
    public static final String PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS = "^[0-9A-Za-záéíóúñÑÁÉÍÓÚ ]+$";
    public static final String PATTERN_CLAVE = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$";

    public UtilText() {
        super();
    }

    public static final String getDefaultValue(final String value, final String defaultValue) {
        return UtilObject.getDefaultValue(value, defaultValue);
    }

    public static final String getDefaultValue(final String value) {
        return getDefaultValue(value, VACIO);
    }

    public static final String applyTrim(final String value) {
        return getDefaultValue(value).trim();
    }

    public static final boolean equalValuesWithoutTrim(final String valueOne, final String valueTwo) {
        return getDefaultValue(valueOne).equals(getDefaultValue(valueTwo));
    }

    public static final boolean equalValuesWithTrim(final String valueOne, final String valueTwo) {
        return applyTrim(valueOne).equals(applyTrim(valueTwo));
    }

    public static final boolean equalValuesWithoutTrimIgnoreCase(final String valueOne, final String valueTwo) {
        return getDefaultValue(valueOne).equalsIgnoreCase(getDefaultValue(valueTwo));
    }

    public static final boolean equalValuesWithTrimIgnoreCase(final String valueOne, final String valueTwo) {
        return applyTrim(valueOne).equalsIgnoreCase(applyTrim(valueTwo));
    }

    public static final boolean isNull(final String value) {
        return UtilObject.isNull(value);
    }

    public static final boolean isEmpty(final String value) {
        return equalValuesWithTrim(value, VACIO);
    }

    public static final boolean minimumValidLength(final String value, final int length) {
        return applyTrim(value).length() >= length;
    }

    public static final boolean maximumValidLength(final String value, final int length) {
        return applyTrim(value).length() <= length;
    }

    public static final boolean validLength(final String value, final int minimumLength, final int maximumLength) {
        return minimumValidLength(value, minimumLength) && maximumValidLength(value, maximumLength);
    }

    public static final boolean containsOnlyLetters(final String value) {
        return getDefaultValue(value).matches(PATTERN_SOLO_LETRAS);
    }

    public static final boolean containsOnlyLettersDigitsSpaces(final String value) {
        return getDefaultValue(value).matches(PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS);
    }

    public static final boolean containsLettersDigitsSpacesCharacters(final String value) {
        return getDefaultValue(value).matches(PATTERN_CLAVE);
    }


}
