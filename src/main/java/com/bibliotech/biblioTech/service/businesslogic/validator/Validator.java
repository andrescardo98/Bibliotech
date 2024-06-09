package com.bibliotech.biblioTech.service.businesslogic.validator;

public interface Validator<T> {

    void execute(T data);
}
