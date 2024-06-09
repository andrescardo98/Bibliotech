package com.bibliotech.biblioTech.service.domain.category.rules;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilText;
import com.bibliotech.biblioTech.service.domain.Rule;

public class CodeCategoryRule implements Rule<String> {

    private static final Rule<String> instance = new CodeCategoryRule();

    private CodeCategoryRule() {
        super();
    }

    public static final void executeValidation(final String data){
        instance.validate(data);
    }

    @Override
    public void validate(String data) {
        validateMandatory(data);
        validateLength(data);
        validateFormat(data);
    }

    private final void validateLength(final String data){
        if (!UtilText.maximumValidLength(data, 3)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000063);
            throw ServiceBibliotechException.create(userMessage);
        }
    }

    private final void validateMandatory(final String data){
        if (UtilText.isEmpty(data)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000064);
            throw ServiceBibliotechException.create(userMessage);
        }
    }

    private final void validateFormat(final String data){
        if (!UtilText.containsOnlyLetters(data)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000065);
            throw ServiceBibliotechException.create(userMessage);
        }
    }
}
