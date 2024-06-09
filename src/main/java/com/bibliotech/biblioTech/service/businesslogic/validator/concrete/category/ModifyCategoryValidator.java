package com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category;

import com.bibliotech.biblioTech.service.businesslogic.validator.Validator;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.domain.category.rules.*;

public class ModifyCategoryValidator implements Validator<CategoryDomain> {

    private static final Validator<CategoryDomain> instance = new ModifyCategoryValidator();

    public ModifyCategoryValidator() {
        super();
    }

    public static final void ejecutar(final CategoryDomain data){
        instance.execute(data);
    }

    @Override
    public void execute(CategoryDomain data) {
        CategoryRule.executeValidation(data);
        IdCategoryRule.executeValidation(data.getId());
        CodeCategoryRule.executeValidation(data.getCode());
        NameCategoryRule.executeValidation(data.getName());
        DescriptionCategoryRule.executeValidation(data.getDescription());
    }
}
