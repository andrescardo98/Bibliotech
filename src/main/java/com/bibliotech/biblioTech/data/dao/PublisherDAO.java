package com.bibliotech.biblioTech.data.dao;

import com.bibliotech.biblioTech.data.entity.PublisherEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PublisherDAO {

    void create(PublisherEntity entity);

    void modify(PublisherEntity entity);

    void delete(UUID id);

    Optional<PublisherEntity> searchById(UUID id);

    List<PublisherEntity> search(PublisherEntity entity);
}
