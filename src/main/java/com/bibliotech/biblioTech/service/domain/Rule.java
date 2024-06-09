package com.bibliotech.biblioTech.service.domain;

public interface Rule<T> {

    void validate(T data);
}
