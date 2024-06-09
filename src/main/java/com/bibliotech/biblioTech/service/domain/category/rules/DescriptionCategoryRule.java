package com.bibliotech.biblioTech.service.domain.category.rules;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilText;
import com.bibliotech.biblioTech.service.domain.Rule;

public class DescriptionCategoryRule implements Rule<String> {

    private static final Rule<String> instance = new DescriptionCategoryRule();

    private DescriptionCategoryRule() {
        super();
    }

    public static final void executeValidation(final String data){
        instance.validate(data);
    }

    @Override
    public void validate(String data) {
        validateMandatory(data);
    }

    private final void validateMandatory(final String data){
        if (UtilText.isEmpty(data)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000067);
            throw ServiceBibliotechException.create(userMessage);
        }
    }
}
