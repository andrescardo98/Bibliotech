package com.bibliotech.biblioTech.controller.support.request;

import com.bibliotech.biblioTech.crosscutting.util.UtilText;
import com.bibliotech.biblioTech.crosscutting.util.UtilUUID;

import java.util.UUID;

public class RequestCategory {
    private UUID id;
    private String name;
    private String description;
    private String code;

    public RequestCategory() {
        setId(UtilUUID.generateUUIDEmpty());
        setName(UtilText.VACIO);
        setDescription(UtilText.VACIO);
        setCode(UtilText.VACIO);
    }

    public RequestCategory(final UUID id, final String name, final String description, final String code) {
        setId(id);
        setName(name);
        setDescription(description);
        setCode(code);
    }

    public final UUID getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final String getDescription() {
        return description;
    }

    public final String getCode() {
        return code;
    }

    public final void setId(final UUID id) {
        this.id = id;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final void setDescription(final String description) {
        this.description = description;
    }

    public final void setCode(final String code) {
        this.code = code;
    }
}
