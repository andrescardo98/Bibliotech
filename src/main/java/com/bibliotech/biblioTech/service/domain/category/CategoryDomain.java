package com.bibliotech.biblioTech.service.domain.category;

import java.util.UUID;

public final class CategoryDomain {
    private UUID id;
    private String name;
    private String description;
    private String code;

    private CategoryDomain(UUID id, String name, String description, String code) {
        setId(id);
        setName(name);
        setDescription(description);
        setCode(code);
    }

    public static final CategoryDomain create(UUID id, String name, String description, String code){
        return new CategoryDomain(id, name, description, code);
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

    public final String getDescription() {
        return description;
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

    public final void setDescription(final String description) {
        this.description = description;
    }
}
