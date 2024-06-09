package com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category;

import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.crosscutting.util.UtilText;
import com.bibliotech.biblioTech.crosscutting.util.UtilUUID;
import com.bibliotech.biblioTech.service.businesslogic.validator.Validator;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.domain.category.rules.*;
import jdk.jshell.execution.Util;

public class SearchCategoryValidator implements Validator<CategoryDomain> {

    private static final Validator<CategoryDomain> instance = new SearchCategoryValidator();

    public SearchCategoryValidator() {
        super();
    }

    public static final void ejecutar(final CategoryDomain data){
        instance.execute(data);
    }

    @Override
    public void execute(final CategoryDomain data) {
        if (!UtilObject.isNull(data)){
            if (!UtilUUID.isUUIDByDefault(data.getId())){
                IdCategoryRule.executeValidation(data.getId());
            }
            if (!UtilText.isEmpty(data.getCode())){
                CodeCategoryRule.executeValidation(data.getCode());
            }
            if (!UtilText.isEmpty(data.getName())){
                NameCategoryRule.executeValidation(data.getName());
            }
            if (!UtilText.isEmpty(data.getDescription())){
                DescriptionCategoryRule.executeValidation(data.getDescription());
            }
        }
    }
}
