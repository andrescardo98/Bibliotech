package com.bibliotech.biblioTech.service.domain.support;

public class FullNameLibrarianDomain {
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;

    private FullNameLibrarianDomain(final String firstName, final String secondName, final String firstLastName,
                                    final String secondLastName) {
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstLastName(firstLastName);
        setSecondLastName(secondLastName);
    }

    public static final FullNameLibrarianDomain create(final String firstName, final String secondName, final String firstLastName,
                                                       final String secondLastName){
        return new FullNameLibrarianDomain(firstName, secondName, firstLastName, secondLastName);
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getSecondName() {
        return secondName;
    }

    public final String getFirstLastName() {
        return firstLastName;
    }

    public final String getSecondLastName() {
        return secondLastName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    public final void setFirstLastName(final String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public final void setSecondLastName(final String secondLastName) {
        this.secondLastName = secondLastName;
    }
}
