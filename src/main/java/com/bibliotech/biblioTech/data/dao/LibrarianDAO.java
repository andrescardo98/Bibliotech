package com.bibliotech.biblioTech.data.dao;

import com.bibliotech.biblioTech.data.entity.LibrarianEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LibrarianDAO {

    void create(LibrarianEntity entity);

    void modify(LibrarianEntity entity);

    void delete(UUID id);

    Optional<LibrarianEntity> searchById(UUID id);

    List<LibrarianEntity> search(LibrarianEntity entity);


}
