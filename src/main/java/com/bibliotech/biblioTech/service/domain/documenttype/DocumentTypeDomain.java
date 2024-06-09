package com.bibliotech.biblioTech.service.domain.documenttype;

import java.util.UUID;

public class DocumentTypeDomain {
    private UUID id;
    private String code;
    private String name;

    private DocumentTypeDomain(final UUID id, final String code, final String name) {
        setId(id);
        setCode(code);
        setName(name);
    }

    public static final DocumentTypeDomain create(final UUID id, final String code, final String name){
        return new DocumentTypeDomain(id, code, name);
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
