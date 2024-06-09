package com.bibliotech.biblioTech.crosscutting.messages;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.CrossCuttingBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCategory;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageType;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.crosscutting.util.UtilText;

public class Message {

    private MessageCode code;
    private MessageType type;
    private MessageCategory category;
    private String content;

    private Message(final MessageCode code, final MessageType type, final MessageCategory category, final String content) {
        super();
        setCode(code);
        setType(type);
        setCategory(category);
        setContent(content);
    }

    public static final Message create(final MessageCode code, final MessageType type, final MessageCategory category,
                                       final String content) {
        return new Message(code, type, category, content);
    }

    public final MessageCode getCode() {
        return code;
    }

    public final MessageType getType() {
        return type;
    }

    public final MessageCategory getCategory() {
        return category;
    }

    public final String getContent() {
        return content;
    }

    public final void setCode(final MessageCode code) {
        if (UtilObject.isNull(code)){
            var userMessage = MessagesCatalog.getMessage(MessageCode.M00000004).getContent();
            var technicalMessage = MessagesCatalog.getMessage(MessageCode.M00000001).getContent();
            throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
        }
        this.code = code;
    }

    public final void setType(final MessageType type) {
        this.type = UtilObject.getDefaultValue(type, MessageType.USER);
    }

    public final void setCategory(final MessageCategory category) {
        this.category = UtilObject.getDefaultValue(category, MessageCategory.FATAL);
    }

    public final void setContent(final String content) {
        this.content = UtilText.applyTrim(content);
    }
}
