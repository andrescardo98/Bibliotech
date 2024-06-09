package com.bibliotech.biblioTech.service.domain.category.rules;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.service.domain.Rule;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;

public class CategoryRule implements Rule<CategoryDomain> {

    private static final Rule<CategoryDomain> instance = new CategoryRule();

    private CategoryRule() {
        super();
    }

    public static final void executeValidation(final CategoryDomain data){
        instance.validate(data);
    }

    @Override
    public void validate(CategoryDomain data) {
        if (UtilObject.isNull(data)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000069);
            throw ServiceBibliotechException.create(userMessage);
        }
    }
}
