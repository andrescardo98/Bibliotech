package com.bibliotech.biblioTech.controller.support.mapper;

import com.bibliotech.biblioTech.controller.support.request.RequestCategory;
import com.bibliotech.biblioTech.service.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryResponse {

    public static final RequestCategory convertToResponse(CategoryDTO dto){
        return new RequestCategory(dto.getId(), dto.getName(), dto.getDescription(), dto.getCode());
    }

    public static final List<RequestCategory> convertListToResponse(List<CategoryDTO> dto){
        List<RequestCategory> results = new ArrayList<>();

        for (int index = 0; index < dto.size(); index++) {
            results.add(convertToResponse(dto.get(index)));
        }
        return results;
    }
}
