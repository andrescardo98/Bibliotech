package com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category;

import com.bibliotech.biblioTech.service.businesslogic.validator.Validator;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.domain.category.rules.*;

public class RegisterCategoryValidator implements Validator<CategoryDomain> {

    private static final Validator<CategoryDomain> instance = new RegisterCategoryValidator();

    public RegisterCategoryValidator() {
        super();
    }

    public static final void ejecutar(final CategoryDomain data){
        instance.execute(data);
    }

    @Override
    public void execute(CategoryDomain data) {
        CategoryRule.executeValidation(data);
        CodeCategoryRule.executeValidation(data.getCode());
        NameCategoryRule.executeValidation(data.getName());
        DescriptionCategoryRule.executeValidation(data.getDescription());
    }
}
