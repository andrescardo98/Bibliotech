package com.bibliotech.biblioTech.controller.support.response;

import com.bibliotech.biblioTech.crosscutting.util.UtilObject;

import java.util.ArrayList;
import java.util.List;

public final class Response<T> {

    private List<T> data;

    private List<String> messages;

    public Response() {
        super();
        setData(new ArrayList<>());
        setMessages(new ArrayList<>());
    }

    public Response(final List<T> data, final List<String> messages) {
        setData(data);
        setMessages(messages);
    }

    public final List<T> getData(){
        return data;
    }

    public final List<String> getMessages(){
        return messages;
    }

    public void setData(final List<T> data) {
        this.data = UtilObject.getDefaultValue(data, new ArrayList<>());
    }

    public void setMessages(final List<String> messages) {
        this.messages = UtilObject.getDefaultValue(messages, new ArrayList<>());
    }
}
