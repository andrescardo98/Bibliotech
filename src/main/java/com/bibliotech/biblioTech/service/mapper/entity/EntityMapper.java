package com.bibliotech.biblioTech.service.mapper.entity;

public interface EntityMapper<E,D> {

    D toDomain(E entity);

    E toEntity(D domain);
}
