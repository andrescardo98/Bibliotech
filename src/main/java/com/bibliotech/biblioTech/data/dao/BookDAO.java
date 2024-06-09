package com.bibliotech.biblioTech.data.dao;

import com.bibliotech.biblioTech.data.entity.BookEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDAO {

    void create(BookEntity entity);

    void modify(BookEntity entity);

    void delete(UUID id);

    Optional<BookEntity> searchById(UUID id);

    List<BookEntity> search(BookEntity entity);
}
