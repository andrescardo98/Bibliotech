package com.bibliotech.biblioTech.data.dao;

import com.bibliotech.biblioTech.data.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryDAO {

    void create(CategoryEntity entity);

    void modify(CategoryEntity entity);

    void delete(UUID id);

    Optional<CategoryEntity> searchById(UUID id);

    //Optional<CategoryEntity> searchByCode(String code);

    List<CategoryEntity> search(CategoryEntity entity);
}
