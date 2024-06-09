package com.bibliotech.biblioTech.data.entity;

import java.util.UUID;

public class PublisherEntity {
    private UUID id;
    private String name;

    private PublisherEntity(final UUID id, final String name) {
        setId(id);
        setName(name);
    }

    public static final PublisherEntity create(final UUID id, final String name){
        return new PublisherEntity(id, name);
    }

    public final UUID getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final void setId(final UUID id) {
        this.id = id;
    }

    public final void setName(final String name) {
        this.name = name;
    }
}
