package com.bibliotech.biblioTech.service.mapper.entity.concrete;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.data.entity.CategoryEntity;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.mapper.entity.EntityMapper;

import java.util.ArrayList;
import java.util.List;

public final class CategoryEntityMapper implements EntityMapper<CategoryEntity, CategoryDomain> {

    private static final EntityMapper<CategoryEntity, CategoryDomain> instance = new CategoryEntityMapper();

    public CategoryEntityMapper() {
        super();
    }

    @Override
    public CategoryDomain toDomain(CategoryEntity entity) {

        if (UtilObject.isNull(entity)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000068);
            throw ServiceBibliotechException.create(userMessage, technicalMessage);
        }
        return CategoryDomain.create(entity.getId(), entity.getName(), entity.getDescription(), entity.getCode());
    }

    @Override
    public CategoryEntity toEntity(CategoryDomain domain) {

        if (UtilObject.isNull(domain)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000069);
            throw ServiceBibliotechException.create(userMessage, technicalMessage);
        }
        return CategoryEntity.create(domain.getId(), domain.getName(),domain.getDescription(), domain.getCode());
    }

    public static final CategoryDomain convertToDomain(final CategoryEntity entity) {
        return instance.toDomain(entity);
    }

    public static final CategoryEntity convertToEntity(final CategoryDomain domain) {
        return instance.toEntity(domain);
    }

    public static final List<CategoryDomain> convertToListDomain(final List<CategoryEntity> entity){
        List<CategoryDomain> results = new ArrayList<>();

        for (int indice = 0; indice < entity.size(); indice++) {
            results.add(convertToDomain(entity.get(indice)));
        }
        return results;
    }
}
