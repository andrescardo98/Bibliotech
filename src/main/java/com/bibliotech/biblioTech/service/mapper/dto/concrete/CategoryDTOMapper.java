package com.bibliotech.biblioTech.service.mapper.dto.concrete;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.data.entity.CategoryEntity;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.dto.CategoryDTO;
import com.bibliotech.biblioTech.service.mapper.dto.DTOMapper;
import com.bibliotech.biblioTech.service.mapper.entity.EntityMapper;
import com.bibliotech.biblioTech.service.mapper.entity.concrete.CategoryEntityMapper;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTOMapper implements DTOMapper<CategoryDTO, CategoryDomain> {

    private static final DTOMapper<CategoryDTO, CategoryDomain> instance = new CategoryDTOMapper();

    public CategoryDTOMapper() {
        super();
    }

    @Override
    public CategoryDomain toDomain(final CategoryDTO dto) {

        if (UtilObject.isNull(dto)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000072);
            throw ServiceBibliotechException.create(userMessage, technicalMessage);
        }
        return CategoryDomain.create(dto.getId(), dto.getName(), dto.getDescription(), dto.getCode());
    }

    @Override
    public CategoryDTO toDTO(CategoryDomain domain) {
        if (UtilObject.isNull(domain)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000073);
            throw ServiceBibliotechException.create(userMessage, technicalMessage);
        }
        return CategoryDTO.create().setId(domain.getId())
                .setName(domain.getName()).setDescription(domain.getDescription()).setCode(domain.getCode());
    }

    public static final CategoryDomain convertToDomain(final CategoryDTO dto){
        return instance.toDomain(dto);
    }

    public static final CategoryDTO convertToDTO(final CategoryDomain domain){
        return instance.toDTO(domain);
    }

    public static final List<CategoryDTO> convertToListDTO(final List<CategoryDomain> dto){
        List<CategoryDTO> results = new ArrayList<>();

        for (int indice = 0; indice < dto.size(); indice++) {
            results.add(convertToDTO(dto.get(indice)));
        }
        return results;
    }
}
