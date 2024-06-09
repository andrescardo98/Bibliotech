package com.bibliotech.biblioTech.data.entity;

import java.util.UUID;

public class AuthorEntity {
    private UUID id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;

    private AuthorEntity(final UUID id, final String firstName, final String secondName, final String firstLastName,
                         final String secondLastName) {
        setId(id);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstLastName(firstLastName);
        setSecondLastName(secondLastName);
    }

    public static final AuthorEntity create(final UUID id, final String firstName, final String secondName,
                                            final String firstLastName, final String secondLastName) {
        return new AuthorEntity(id, firstName, secondName, firstLastName, secondLastName);
    }

    public final UUID getId() {
        return id;
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

    public final void setId(final UUID id) {
        this.id = id;
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
