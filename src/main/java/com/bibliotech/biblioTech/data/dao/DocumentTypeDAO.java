package com.bibliotech.biblioTech.data.dao;

import com.bibliotech.biblioTech.data.entity.DocumentTypeEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DocumentTypeDAO {

    void create(DocumentTypeEntity entity);

    void modify(DocumentTypeEntity entity);

    void delete(UUID id);

    Optional<DocumentTypeEntity> searchById(UUID id);

    List<DocumentTypeEntity> search(DocumentTypeEntity entity);
}
