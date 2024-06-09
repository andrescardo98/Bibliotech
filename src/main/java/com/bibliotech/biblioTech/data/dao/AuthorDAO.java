package com.bibliotech.biblioTech.data.dao;

import com.bibliotech.biblioTech.data.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorDAO {

    void create(AuthorEntity entity);

    void modify(AuthorEntity entity);

    void delete(UUID id);

    Optional<AuthorEntity> searchById(UUID id);

    List<AuthorEntity> search(AuthorEntity entity);
}
