package com.bibliotech.biblioTech.data.entity;

import java.util.UUID;

public class DocumentTypeEntity {
    private UUID id;
    private String code;
    private String name;

    private DocumentTypeEntity(final UUID id, final String code, final String name) {
        setId(id);
        setCode(code);
        setName(name);
    }

    public static final DocumentTypeEntity create(final UUID id, final String code, final String name){
        return new DocumentTypeEntity(id, code, name);
    }

    public final UUID getId() {
        return id;
    }

    public final String getCode() {
        return code;
    }

    public final String getName() {
        return name;
    }

    public final void setId(final UUID id) {
        this.id = id;
    }

    public final void setCode(final String code) {
        this.code = code;
    }

    public final void setName(final String name) {
        this.name = name;
    }
}
