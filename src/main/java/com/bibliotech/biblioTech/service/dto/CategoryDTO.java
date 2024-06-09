package com.bibliotech.biblioTech.service.dto;

import com.bibliotech.biblioTech.crosscutting.util.UtilText;
import com.bibliotech.biblioTech.crosscutting.util.UtilUUID;

import java.util.UUID;

public final class CategoryDTO {
    private UUID id;
    private String name;
    private String description;
    private String code;

    public CategoryDTO() {
        setId(UtilUUID.generateUUIDEmpty());
        setName(UtilText.VACIO);
        setDescription(UtilText.VACIO);
        setCode(UtilText.VACIO);
    }

    public CategoryDTO(final UUID id, final String name, final String description, final String code){
        setId(id);
        setName(name);
        setDescription(description);
        setCode(code);
    }

    public static final CategoryDTO create(){
        return new CategoryDTO();
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

    public final CategoryDTO setId(final UUID id) {
        this.id = UtilUUID.getDefaultValue(id, UtilUUID.getDefaultValue(id, UtilUUID.UUID_DEFAULT));
        return this;
    }

    public final CategoryDTO setCode(final String code) {
        this.code = UtilText.getDefaultValue(UtilText.applyTrim(code), UtilText.VACIO);
        return this;
    }

    public final CategoryDTO setName(final String name) {
        this.name = UtilText.getDefaultValue(UtilText.applyTrim(name), UtilText.VACIO);
        return this;
    }

    public final CategoryDTO setDescription(final String description) {
        this.description = UtilText.getDefaultValue(UtilText.applyTrim(description), UtilText.VACIO);
        return this;
    }
}
