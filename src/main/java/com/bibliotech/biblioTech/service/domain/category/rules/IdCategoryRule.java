package com.bibliotech.biblioTech.service.domain.category.rules;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilUUID;
import com.bibliotech.biblioTech.service.domain.Rule;
import jdk.jshell.execution.Util;

import java.util.UUID;

public class IdCategoryRule implements Rule<UUID> {

    private static final Rule<UUID> instance = new IdCategoryRule();

    private IdCategoryRule() {
        super();
    }

    public static final void executeValidation(final UUID data){
        instance.validate(data);
    }

    @Override
    public void validate(UUID data) {
        validateMandatory(data);
    }

    private final void validateMandatory(final UUID data){
        if (UtilUUID.isNull(data)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000062);
            throw ServiceBibliotechException.create(userMessage);
        }
    }
}
