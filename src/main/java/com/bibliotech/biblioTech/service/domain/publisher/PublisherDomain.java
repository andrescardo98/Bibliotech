package com.bibliotech.biblioTech.service.domain.publisher;

import java.util.UUID;

public class PublisherDomain {
    private UUID id;
    private String name;

    private PublisherDomain(final UUID id, final String name) {
        setId(id);
        setName(name);
    }

    public static final PublisherDomain create(final UUID id, final String name){
        return new PublisherDomain(id, name);
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
