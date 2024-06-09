package com.bibliotech.biblioTech.service.domain.category.rules;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilText;
import com.bibliotech.biblioTech.service.domain.Rule;
import jdk.jshell.execution.Util;

public class NameCategoryRule implements Rule<String> {

    private static final Rule<String> instance = new NameCategoryRule();

    private NameCategoryRule() {
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
        if (!UtilText.maximumValidLength(data, 70)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000066);
            throw ServiceBibliotechException.create(userMessage);
        }
    }

    private final void validateMandatory(final String data){
        if (UtilText.isEmpty(data)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000067);
            throw ServiceBibliotechException.create(userMessage);
        }
    }

    private final void validateFormat(final String data){
        if (!UtilText.containsOnlyLettersDigitsSpaces(data)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000068);
            throw ServiceBibliotechException.create(userMessage);
        }
    }
}
