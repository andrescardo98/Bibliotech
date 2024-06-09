package com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category;

import com.bibliotech.biblioTech.service.businesslogic.validator.Validator;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.domain.category.rules.CategoryRule;
import com.bibliotech.biblioTech.service.domain.category.rules.CodeCategoryRule;
import com.bibliotech.biblioTech.service.domain.category.rules.IdCategoryRule;
import com.bibliotech.biblioTech.service.domain.category.rules.NameCategoryRule;

public class DeleteCategoryValidator implements Validator<CategoryDomain> {

    private static final Validator<CategoryDomain> instance = new DeleteCategoryValidator();

    public DeleteCategoryValidator() {
        super();
    }

    public static final void ejecutar(final CategoryDomain data){
        instance.execute(data);
    }

    @Override
    public void execute(CategoryDomain data) {
        CategoryRule.executeValidation(data);
        //IdCategoryRule.executeValidation(data.getId());
        CodeCategoryRule.executeValidation(data.getCode());
    }
}
